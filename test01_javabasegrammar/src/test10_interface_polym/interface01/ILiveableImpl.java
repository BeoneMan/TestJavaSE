package test10_interface_polym.interface01;

public class ILiveableImpl implements  ILiveable {


    @Override
    public void fly03() {
        System.out.println("重写抽象方法");
    }
}
