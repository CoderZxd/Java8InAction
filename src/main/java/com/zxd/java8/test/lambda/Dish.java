package com.zxd.java8.test.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * @Title: Dish
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/27 19:31
 */
public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public int getCalories() {
		return calories;
	}
	public Type getType() {
		return type;
	}
	@Override
	public String toString() {
		return name;
	}

	public enum Type { MEAT, FISH, OTHER }

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		List<String> names = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(toList());
		System.out.println(names);
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> dish = menu.stream().collect(maxBy(dishCaloriesComparator));
		if(dish.isPresent()){
			System.out.println(dish.get());
		}
		int sum = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(sum);
		int sum2 = menu.stream().map(Dish::getCalories).reduce(0,(a,b)->a+b);
		System.out.println(sum2);
		double avg = menu.stream().collect(averagingDouble(Dish::getCalories));
		System.out.println(avg);
		IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(intSummaryStatistics);
		System.out.println(intSummaryStatistics.getCount());
		String namessss = menu.stream().map(Dish::getName).collect(joining(","));
		System.out.println(namessss);
//		String names2 = menu.stream().collect(joining());
//		System.out.println(names2);
		int total = menu.stream().collect(reducing(0,Dish::getCalories,(i,j)->i+j));
		System.out.println(total);
		int total2 = menu.stream().collect(reducing(0,Dish::getCalories,Integer::sum));
		System.out.println(total2);
		Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish1 -> {
			if(dish1.getCalories()<=400){
				return CaloricLevel.DIET;
			}else if(dish1.getCalories() <= 700){
				return CaloricLevel.NORMAL;
			}
			return CaloricLevel.FAT;
		}));
		System.out.println(dishesByCaloricLevel);

		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
			groupingBy(Dish::getType,
					groupingBy(dish2 -> {
						if(dish2.getCalories() <= 400){
							return CaloricLevel.DIET;
						}
						else if(dish2.getCalories() <= 700){
							return CaloricLevel.NORMAL;
						}
						else{
							return CaloricLevel.FAT;
						}
					} )
			)
		);
		System.out.println(dishesByTypeCaloricLevel);

		Map<Dish.Type,Long> types = menu.stream().collect(groupingBy(Dish::getType,counting()));
		System.out.println(types);

		Map<Dish.Type,Optional<Dish>> maxs = menu.stream().collect(groupingBy(Dish::getType,maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(maxs);

		Map<Dish.Type,Dish> maxss = menu.stream().collect(groupingBy(Dish::getType,collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));
		System.out.println(maxss);
		int processor = Runtime.getRuntime().availableProcessors();
		System.out.println(processor);
		Map<Boolean,List<Dish>> patitions = menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(patitions);
		List<Dish> ver = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		System.out.println(ver);
		System.out.println(partitionPrimes(10));
		System.out.println(menu.stream().collect(Collectors.toList()));
	}
	public static enum CaloricLevel { DIET, NORMAL, FAT };

	public static boolean isPrime(int candidate){
		int candidateRoot = (int)Math.sqrt((double) candidate);
		System.out.println(String.format("candidate:%d;candidateRoot:%d",candidate,candidateRoot));
		return IntStream.rangeClosed(2,candidateRoot).noneMatch(i -> candidate % i == 0);
	}

	public static Map<Boolean,List<Integer>> partitionPrimes(int i){
		return IntStream.rangeClosed(2,i).boxed().collect(partitioningBy(candicate -> isPrime(candicate)));
	}
}
