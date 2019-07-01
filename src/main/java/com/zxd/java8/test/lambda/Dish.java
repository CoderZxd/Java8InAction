package com.zxd.java8.test.lambda;

import java.util.*;

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
	}
}
