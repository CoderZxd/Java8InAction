package com.zxd.java8.test.lambda;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
	}
}
