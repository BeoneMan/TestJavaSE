package test10_interface_polym.interface01;

public interface ILiveable {

    String name = "hello";//默认设置为常量 等同于 public static final String NAME="hello";
    public static final int AGE = 18;

//    public ILiveable(){} 接口中不能有构造器


    public default void fly01() {
        System.out.println("默认方法");
    }


    public static void fly02() {
        System.out.println("静态方法");
    }

    public abstract void fly03();

    private void fly04() {
        System.out.println("私有方法");
    }

}
