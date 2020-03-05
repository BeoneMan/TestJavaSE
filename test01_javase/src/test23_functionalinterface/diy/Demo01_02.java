package test23_functionalinterface.diy;


/**
 * 测试自定义函数接口
 */
public class Demo01_02 {
    public static void main(String[] args) {
        test01(()-> System.out.println("01执行自定义函数接口了..."));
        test02(()-> System.out.println("02执行自定义函数接口了..."));
    }

    public static void test01(DiyFunctionalInterfaceDemo01 df){
        df.mymethod();
    }
    public static void test02(DiyFunctionalInterfaceDemo02 df){
        df.mymethod();
    }
}
