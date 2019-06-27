package com.zxd.java8.test.lambda;

import java.util.function.Function;

/**
 * @Title: Letter
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/27 18:56
 */
public class Letter {
	public static String addHeader(String text){
		return "From Raoul, Mario and Alan: " + text;
	}
	public static String addFooter(String text){
		return text + " Kind regards";
	}
	public static String checkSpelling(String text){
		return text.replaceAll("labda", "lambda");
	}

	public static void main(String[] args) {
		Function<String,String> addHeader = Letter::addHeader;
		Function<String,String> transformatPipeline = addHeader.andThen(Letter::addFooter).andThen(Letter::checkSpelling);
		String test = "Hello world,I am labda.";
		System.out.println(transformatPipeline.apply(test));
	}
}
