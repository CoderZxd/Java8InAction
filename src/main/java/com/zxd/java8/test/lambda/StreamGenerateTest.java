package com.zxd.java8.test.lambda;

import java.util.stream.Stream;

public class StreamGenerateTest {
    public static void main(String[] args) {
        Stream.iterate(0,n-> n+2).limit(10).forEach(System.out::println);
        //生成斐波那契数列
        Stream.iterate(new int[]{0,1},e -> new int[]{e[1],e[0]+e[1]}).limit(20).forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
