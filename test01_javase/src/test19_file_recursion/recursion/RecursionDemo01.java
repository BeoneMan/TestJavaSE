package test19_file_recursion.recursion;

/**
 * 计算1 ~ n的和
 * 分析：num的累和 = num + (num-1)的累和，所以可以把累和的操作定义成一个方法，递归调用
 */
public class RecursionDemo01 {
    private static int sum = 0;

    public static void main(String[] args) {
        getNum(3);
        System.out.println(sum);
    }

    private static void getNum(int i) {
        if (i == 0) return;
        sum += i;
        getNum(--i);
    }
}
