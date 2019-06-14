package com.application.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        Stream<String> language = Stream.of("java", "python", "C++","php","java");
        List<Object> list = language.collect(Collectors.toList());
        list.stream().forEach(item ->{
            System.out.println(item);
        });

    }
}
