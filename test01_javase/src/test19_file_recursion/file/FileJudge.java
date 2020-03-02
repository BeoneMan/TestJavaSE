package test19_file_recursion.file;

import java.io.File;

/**
 *
 * public boolean exists() ：此File表示的文件或目录是否实际存在。
 * public boolean isDirectory() ：此File表示的是否为目录。
 * public boolean isFile() ：此File表示的是否为文件。
 */
public class FileJudge {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\玩转火车采集器，你一定要听的9节课");
        System.out.println(file+(file.exists()?"存在":"不存在"));
        System.out.println(file+(file.isDirectory()?"是文件夹":"是文件"));
        System.out.println(file+(file.isFile()?"是文件":"是文件夹"));
    }
}
