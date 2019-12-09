package test08_string_static_arrays_math.math;

//计算在 -10.8 到 5.9 之间，绝对值大于 6 或者小于 2.1 的整数有多少个？
public class MathDemo02 {
    public static void main(String[] args) {
        int count = 0;
        double min = Math.ceil(-10.8);
        double max = Math.floor(5.9);
        for (double i = min; i <= max; i++) {
            if (Math.abs(i) > 6 || Math.abs(i) < 2.1) count++;
        }
        System.out.println(count);
    }
}
