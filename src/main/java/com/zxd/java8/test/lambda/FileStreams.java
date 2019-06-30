package com.zxd.java8.test.lambda;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileStreams {

    public static void main(String[] args) {
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("D:/1.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(uniqueWords);
    }
}
