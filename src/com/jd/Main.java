package com.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Java8 中stream流的 forEach 及 foreEachOrdered 的区别
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("x");
        list.add("y");
        list.add("z");

        list.parallelStream().forEach(x -> System.out.println(x));
        list.parallelStream().forEachOrdered(x -> System.out.println(x));

        //主要的区别在并行流的处理上
        //输出的顺序不一定（效率更高）
        Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
        //输出的顺序与元素的顺序严格一致
        Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));
    }
}
