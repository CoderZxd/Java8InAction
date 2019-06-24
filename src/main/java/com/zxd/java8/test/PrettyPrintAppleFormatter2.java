package com.zxd.java8.test;

import java.util.List;

/**
 * @Title: PrettyPrintAppleFormatter2
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/24 18:43
 */
public class PrettyPrintAppleFormatter2 implements PrettyPrintApple<Apple,String> {

	@Override public String printToString(List<Apple> apples) {
		return "PrettyPrintAppleFormatter2";
	}
}
