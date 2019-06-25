package com.zxd.java8.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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

	public static <T> List<T> predicate(List<T> list,Predicate<T> predicate){
		List<T> result = new ArrayList<>();
		for(T e:list){
			if(predicate.test(e)){
				result.add(e);
			}
		}
		return result;
	}

	public static <T,R> List<R> map(List<T> list, Function<T,R> function){
		List<R> result = new ArrayList<>();
		for(T e:list){
			result.add(function.apply(e));
		}
		return result;
	}

	public static <T> void forEach(List<T> list, Consumer<T> consumer){
		for(T e:list){
			consumer.accept(e);
		}
	}

	public static void main(String[] args) {
		List<Integer> result = filter(Arrays.asList(1,2,3,4,5,6),(Integer i) -> i % 2 == 0);
		System.out.println(result);
		List<Integer> test = Arrays.asList(7,8,9,1,2,3,4,5,6);
		test.sort((Integer o1,Integer o2) -> o1.compareTo(o2));
		System.out.println(test);
		String hello = "Hello world";
		Thread t = new Thread(()-> System.out.println(hello));
		t.start();
		System.out.println(predicate(Arrays.asList(7,8,9,1,2,3,4,5,6),(Integer i) -> i%2==0 ));
		System.out.println(map(Arrays.asList(7,8,9,1,2,3,4,5,6),(Integer integer) -> integer*2));
		forEach(Arrays.asList(7,8,9,1,2,3,4,5,6),(Integer i)-> System.out.println(i));

		List<String> str = Arrays.asList("a","b","A","B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(str);
		str = Arrays.asList("a","b","c","A","B","C");
		str.sort(String::compareToIgnoreCase);
		System.out.println(str);
	}
}