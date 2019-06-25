package com.zxd.java8.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: Predicate
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/25 14:28
 */
public interface Predicate<T> {
	boolean test(T t);
}

class Test{

	public static <T> List<T> filter(List<T> list,Predicate<T> p){
		List<T> result = new ArrayList<>(10);
		for(T e:list){
			if(p.test(e)){
				result.add(e);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = filter(Arrays.asList(1,2,3,4,5,6),(Integer i) -> i % 2 == 0);
		System.out.println(result);
		List<Integer> test = Arrays.asList(7,8,9,1,2,3,4,5,6);
		test.sort((Integer o1,Integer o2) -> o1.compareTo(o2));
		System.out.println(test);
		Thread t = new Thread(()-> System.out.println("Hello world"));
		t.start();
	}
}