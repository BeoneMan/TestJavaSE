package test16_exception_thread.lambda;

import java.util.Arrays;
import java.util.Collections;

/**
 * 需求:
 * 使用数组存储多个Person对象
 * 对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
 */
public class TestPerson {
    public static void main(String[] args) {
        Person[] persons = {new Person(18, "zhongmei"), new Person(16, "xiaomei"), new Person(19, "damei")};
        Arrays.sort(persons,(o1,o2)-> o1.getAge()-o2.getAge());
        System.out.println(Arrays.toString(persons));
    }
}
