package test08_string_static_arrays_math.arrays;

import java.util.Arrays;

public class ArraysDemo01 {
    public static void main(String[] args) {
//        public static String toString(int[] a) ：
//        返回指定数组内容的字符串表示形式。
        int [] arr ={21,14,5,23,554,6,754};
        System.out.println(Arrays.toString(arr));

        System.out.println("--------");

//        public static void sort(int[] a) ：对指定的 int 型数组按数字升序进行排序。
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
