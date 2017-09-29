package com.jd.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-09-28 18:20
 */
public class CollectionTest {

    @Test
    public void testList() {
        // 未妥投的订单号
        List<String> orderIdList = Arrays.asList("111", "2222");

        // 调用青龙接口查询实物子订单的妥投状态
        List<Long> resultList = Arrays.asList(333L);

        // 检验青龙接口是否返回了非法的订单Id
        List<Long> collect = resultList.stream().filter(orderId -> orderIdList.contains(orderId + "")).collect(toList());
        if (collect.size() == 0) {
            System.out.println("Deliver interface return illegal orderId resultList={}" + resultList);
        }

        System.out.println("collect==============" + collect);
    }
}