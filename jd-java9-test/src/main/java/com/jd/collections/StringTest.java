package com.jd.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-09-28 18:20
 */
public class StringTest {

    @Test
    public void testStr() {
        String str1 = "xxx";
        String str2 = "yyy";

        //将两个字符串进行拼接
        String joinStr = String.join("_", str1, str2);
        System.out.println("joinStr============>" + joinStr);

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        //把list 里面的元素使用 - 拼接起来
        String join = String.join("-", list);

        System.out.println("join========>" + join);
    }

    @Test
    public void testStream2Str() {
        List<String> list = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = list.stream();
        list.add("three");

        //将字符串用 _ 拼接起来
        String str = sl.collect(joining("_"));
        System.out.println("str=========>" + str);

        //拼接字符串并添加  前后缀
        String str2 = list.stream().collect(joining("_", "prefix", "suffix"));
        System.out.println("str2=========>" + str2);
    }

}