package com.zxd.java8.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1,6, 3, 3, 2, 4);
        numbers.stream().filter(i -> i%2 == 0).distinct().limit(2).forEach(System.out::println);
        numbers.stream().filter(i -> i%2 == 0).distinct().skip(2).forEach(System.out::println);
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> lengths = words.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(lengths);
        List<Integer> test = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(test);
    }
}
