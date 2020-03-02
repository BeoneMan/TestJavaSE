package test19_file_recursion.file;

import java.io.File;

/**
 * File(File parent, String child)
 * 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
 * <p>
 * File(String pathname)
 * 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
 * <p>
 * File(String parent, String child)
 * 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
 */
public class FileConstructorDemo {
    public static void main(String[] args) {
        // File(String pathname)
        // 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
        File file01 = new File("C:\\Users\\Administrator\\Desktop");
        System.out.println(file01);


        //File(File parent, String child)
        //根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
        File file02 = new File(file01, "a\\b");
        System.out.println(file02);

        //File(String parent, String child)
        File file03 = new File("C:\\Users\\Administrator\\Desktop", "a\\c");
        System.out.println(file03);
    }

}
