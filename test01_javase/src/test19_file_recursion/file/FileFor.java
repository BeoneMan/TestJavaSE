package test19_file_recursion.file;

import java.io.File;

/**
 * public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
   public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。

 */
public class FileFor {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\玩转火车采集器，你一定要听的9节课");
        String[] strList = file.list();
        for(String s:strList){
            System.out.println(s);
        }
        System.out.println("--------");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }
}
