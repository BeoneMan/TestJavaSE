package test07_scanner_random_arraylist.scanner;

import java.util.Scanner;

public class ScannerDemo01 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        sum();
        int max = getMax();
        System.out.println("最大值为：" + max);
    }

    public static void sum() {
        System.out.println("输入第一个数据");
        int one = sc.nextInt();
        System.out.println("输入第二个数据");
        int two = sc.nextInt();
        System.out.println(one + two);
    }


    public static int getMax() {
        int max = 0;
        System.out.println("输入第一个数据");
        int one = sc.nextInt();
        System.out.println("输入第二个数据");
        int two = sc.nextInt();
        System.out.println("输入第三个数据");
        int three = sc.nextInt();

        max = one > two ? one : two;
        return max > three ? max : three;

    }

}
