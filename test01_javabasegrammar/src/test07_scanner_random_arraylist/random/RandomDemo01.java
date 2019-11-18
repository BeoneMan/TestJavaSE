package test07_scanner_random_arraylist.random;


import java.util.Random;
import java.util.Scanner;

public class RandomDemo01 {
    static Random rd = new Random();

    public static void main(String[] args) {
//        getRandom();
        guessNumber();
    }

    //获取随机数
    public static void getRandom() {
        int i = rd.nextInt(10);
        System.out.println(i);
    }

    //猜数字小游戏
    public static void guessNumber() {
        int number = rd.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("输入你要猜的数字");
            int myNumber = sc.nextInt();
            if (myNumber > number) {
                System.out.println("数字猜大了");
            } else if (myNumber < number) {
                System.out.println("数字猜小了");
            } else {
                System.out.println("恭喜你猜中了");
                break;
            }
        }

    }
}

