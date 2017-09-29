package com.jd.enums;

import java.util.Arrays;

/**
 * Created by wangyingjie1 on 2017/1/16.
 */
public enum SwitchEnum {

    ONE(1, "x"),
    TWO(2, "x"),
    THREE(3, "x2");

    private int type;
    private String name;

    SwitchEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    // 查找某一个枚举值
    public static SwitchEnum findAny(int type) {
        return Arrays.stream(SwitchEnum.values())
                .filter(switchEnum -> switchEnum.getType() == type)
                .findAny()
                .orElse(null);
    }

    public static SwitchEnum findFirst(String name) {
        return Arrays.stream(SwitchEnum.values())
                .filter(switchEnum -> switchEnum.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


    // 枚举匹配
    public static boolean anyMatch(int type) {
        return Arrays.stream(SwitchEnum.values())
                //匹配任何一个则返回
                .anyMatch(switchEnum -> switchEnum.getType() == type);
    }

    // 枚举匹配
    public static boolean allMatch(String name) {
        return Arrays.stream(SwitchEnum.values())
                //匹配所有
                .allMatch(switchEnum -> switchEnum.getName().equals(name));
    }


    public int getType() {
        return type;
    }


    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println("findAny============>" + findAny(1));
        System.out.println("findFirst============>" + findFirst("x"));
        System.out.println("anyMatch============>" + anyMatch(2));
        System.out.println("anyMatch============>" + allMatch("x"));
    }
}
