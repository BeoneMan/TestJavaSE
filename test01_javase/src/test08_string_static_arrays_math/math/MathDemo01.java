package test08_string_static_arrays_math.math;

public class MathDemo01 {
    public static void main(String[] args) {
//        public static double abs(double a) ：返回 double 值的绝对值。
//        public static double ceil(double a) ：返回大于等于参数的最小的整数。
//        public static double floor(double a) ：返回小于等于参数最大的整数。
//        public static long round(double a) ：返回最接近参数的 long。(相当于四舍五入方法)
        double d1=-5.1;
        System.out.println(d1+"的绝对值为"+Math.abs(d1));
        System.out.println(Math.ceil(d1));
        System.out.println(Math.floor(d1));
        System.out.println(Math.round(d1));

    }
}
