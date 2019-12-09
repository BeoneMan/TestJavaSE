package test10_interface_polym.interface01.example;

public class TestDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        USB usb = new Mouse();
//        USB usb = new Keyboard();

        computer.openComputer();
        computer.UseUSB(usb);

        computer.closeComputer();
    }
}
