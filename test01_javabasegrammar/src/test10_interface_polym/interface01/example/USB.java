package test10_interface_polym.interface01.example;

public interface USB {
    default void open(){
        System.out.println("USB开启了");
    }

    default void close(){
        System.out.println("USB关闭了");
    }
}
