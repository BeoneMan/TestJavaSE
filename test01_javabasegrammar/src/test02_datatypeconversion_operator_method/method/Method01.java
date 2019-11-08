package test02_datatypeconversion_operator_method.method;

/**
 * 方法入门练习
 */
public class Method01 {
    public static void main(String[] args) {
        hello("源哥");
      /*  private static void hello2() {
        }*/   //一个方法不能定义在另一个方法的内部
    }

    private static void hello(String name) {
        System.out.println(name + "," + "你可以的");
    }
}
