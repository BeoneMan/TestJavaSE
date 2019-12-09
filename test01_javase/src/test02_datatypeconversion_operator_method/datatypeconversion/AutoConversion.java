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

        System.out.println("========");
        byte b1=1;
        byte b2=2;
        byte b3=1 + 2;
        byte b4= (byte) (b1 + b2);
        System.out.println(b3);//编译时期，已经把1+2计算成了3
        System.out.println(b4);//因为JVM编译期不知b1变量和b2变量的值是否确定，所以会先转为int类型计算
    }

}
