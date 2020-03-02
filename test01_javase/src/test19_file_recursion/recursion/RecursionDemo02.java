package test19_file_recursion.recursion;

import javax.xml.transform.Source;
import java.io.File;

/**
 * 递归打印多级目录
 */
public class RecursionDemo02 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\玩转火车采集器，你一定要听的9节课");
        printFile(file);
    }

    private static void printFile(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) System.out.println("文件名：" + f.getAbsolutePath());
                else {
                    System.out.println("目录名：" + f.getAbsolutePath());
                    printFile(f);
                }
            }
        }
    }

}
