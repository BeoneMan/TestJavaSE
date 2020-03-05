package test23_functionalinterface.common;

import java.util.function.Supplier;

/**
 * 练习：求数组元素最大值
 * 题目
 * 使用 Supplier 接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。提示：接口的泛型请使用
 * java.lang.Integer 类。
 */
public class SuppilerDemo02 {
    public static void main(String[] args) {
        Integer i1 = 100 ;
        Integer i2 = 200 ;
        System.out.println(getMax(()->i1>i2?i1:i2));
    }

    public static Integer getMax(Supplier<Integer> sl){
        return sl.get();
    }
}
