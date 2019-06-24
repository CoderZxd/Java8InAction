package com.zxd.java8.test;

import java.util.List;

/**
 * @Title: PrettyPrintAppleTest
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/24 18:44
 */
public class PrettyPrintAppleTest {

	public static void main(String[] args) {
		System.out.println(testT(null,new PrettyPrintAppleFormatter1()));
		System.out.println(testT(null,new PrettyPrintAppleFormatter2()));
	}

	private static String testT(List<Apple> apples,PrettyPrintApple prettyPrintApple){
		return (String)prettyPrintApple.printToString(apples);
	}
}
