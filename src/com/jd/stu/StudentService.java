package com.jd.stu;

//java9 新特性之接口支持私有方法
public interface StudentService {

    default void getStudent1() {
        String stu = getStu();
        System.out.println("stu1======>" + stu);
    }

    default void getStudent2() {
        String stu = getStu();
        System.out.println("stu2======>" + stu);
    }

    private String getStu() {
        return "hello world!";
    }

}
