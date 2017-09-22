package com.jd.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//java9 可以将Optional可以直接转为stream 流来进行处理
public class OptionalTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("xxx1");
        list.add("xxx2");
        list.add("xxx3");

        Optional<List<String>> optional = Optional.ofNullable(list);
        optional.stream()//optional 可以转为stream
                .forEachOrdered(x -> x.stream().forEach(y -> System.out.println(y)));

        list.add("yyy1");
        Optional<List<String>> optional2 = Optional.ofNullable(list);
        optional2.stream()
                .flatMap(x -> x.stream())//optional 扁平化
                .forEach(System.out::println);
    }
}
