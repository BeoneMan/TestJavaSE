package test10_interface_polym.interface01.example;

//  进行描述笔记本类实现笔记本使用USB鼠标、USB键盘
//  USB接口，包含开启功能、关闭功能
//  笔记本类，包含运行功能、关机功能、使用USB设备功能
//  鼠标类，要实现USB接口，并具备点击的方法
//  键盘类，要实现USB接口，具备敲击的方法
public class Computer {
    public void openComputer() {
        System.out.println("笔记本开机了");
    }

    public void closeComputer() {
        System.out.println("笔记本关机了");
    }

    public void UseUSB(USB usb) {
        if (usb != null) {
            usb.open();

            if (usb instanceof Mouse) {
                Mouse mouse = (Mouse) usb;
                mouse.click();
            } else {
                Keyboard kb = (Keyboard) usb;
                kb.knock();
            }
            usb.close();
        }

    }
}
