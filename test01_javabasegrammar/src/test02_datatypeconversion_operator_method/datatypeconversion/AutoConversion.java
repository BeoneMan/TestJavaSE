package test02_datatypeconversion_operator_method.datatypeconversion;

/**
 * 一个 int 类型变量和一个 byte 类型变量进行加法运算，
 * 结果会是什么数据类型？
 */
public class AutoConversion {
    public static void main(String[] args) {
        int i =126;
        byte b =2;
        int sum =i+b;
        byte sum2 = (byte)(i+b);

        System.out.println(sum);//128
        System.out.println(sum2);//-128
    }

}
