package com.jd.stu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Student {

    private int id;
    private String sex;
    private String name;

    public static void main(String[] args) {
        List<Student> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setId(i);
            student.setSex(i % 2 == 0 ? "男" : "女");
            student.setName("zhangsan" + i);
            list.add(student);
        }
        //将所有的学生按照性别进行分组
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getSex));

        //用方法引用可读性更好
        Map<String, List<Student>> collect2 = list.stream().collect(groupingBy(Student::getSex));

        //按照Id分组
        Map<Integer, List<Student>> collect3 = list.stream().collect(groupingBy(Student::getId));

        //自定义函数分组
        Map<Integer, List<Student>> collect4 = list.stream().collect(groupingBy(stu -> stu.hashCode() % 5));

        System.out.println(collect);
        System.out.println(collect2);
        System.out.println(collect3);
        System.out.println(collect4);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
