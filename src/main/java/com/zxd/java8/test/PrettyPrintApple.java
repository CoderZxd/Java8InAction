package com.zxd.java8.test;

import java.util.List;

/**
 * @Title: PrettyPrintApple
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/24 18:15
 */
public interface PrettyPrintApple<T,R> {

	R printToString(List<T> apples);
}
