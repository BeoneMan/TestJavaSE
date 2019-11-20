package test10_interface_polym.interface01;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println(ILiveable.name);
//        ILiveable.name="world";  错误
        ILiveable.fly02();//执行接口中的静态方法

        ILiveable li =new ILiveableImpl();
        li.fly01();
        li.fly03();

    }
}
