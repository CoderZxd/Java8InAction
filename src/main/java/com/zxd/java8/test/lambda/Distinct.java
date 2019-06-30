package com.zxd.java8.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Distinct {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1,6, 3, 3, 2, 4);
        numbers.stream().filter(i -> i%2 == 0).distinct().limit(2).forEach(System.out::println);
        numbers.stream().filter(i -> i%2 == 0).distinct().skip(2).forEach(System.out::println);
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> lengths = words.stream().map(e -> e.length()).collect(toList());
        System.out.println(lengths);
        List<Integer> test = words.stream().map(String::length).collect(toList());
        System.out.println(test);
        List<String[]> temp = words.stream().map(e -> e.split("")).collect(toList());
        List<String> ll = words.stream().map(e -> e.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(ll);
        List<Integer> tem = Arrays.asList(1,2,3,4,5);
        System.out.println(tem.stream().map(n -> n * n).collect(toList()));
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> re = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i,j})).distinct().collect(toList());
        System.out.println(re);
        //过滤总和可以被3整除的
        List<int[]> ret = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i,j})).filter(a -> (a[0]+a[1])%3 == 0).collect(toList());
        System.out.println(ret.size());
        List<int[]> ret2 = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i+j)%3 ==0 ).map(j -> new int[]{i,j})).collect(toList());
        System.out.println(ret2.size());
        if(tem.stream().anyMatch(i -> i > 4)){
            System.out.println("i>4");
        }
        if(tem.stream().allMatch(i -> i>0)){
            System.out.println("i>0");
        }
        //找出第一个平方能被3整除的数
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream().filter(i->i*i%3==0).findFirst();
        if(first.isPresent()){
            System.out.println(first.get());
        }
        int sum = someNumbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);
        int sum2 = someNumbers.stream().reduce(0,Integer::sum);
        System.out.println(sum2);
    }
}
