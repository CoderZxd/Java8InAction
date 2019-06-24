package com.zxd.java8.test;

import java.util.List;

/**
 * @Title: PrettyPrintAppleFormatter1
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/24 18:19
 */
public class PrettyPrintAppleFormatter1 implements PrettyPrintApple<Apple,String>{

	@Override public String printToString(List<Apple> apples) {
		return "PrettyPrintAppleFormatter1";
	}
}