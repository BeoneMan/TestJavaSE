package test19_file_recursion.file;

import java.io.File;
import java.io.IOException;

/**
 *
 *  public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
     public boolean delete() ：删除由此File表示的文件或目录。
     public boolean mkdir() ：创建由此File表示的目录。
     public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
 *
 */
public class FileDelete {
    public static void main(String[] args) throws IOException {
        File file =new File("C:\\Users\\Administrator\\Desktop\\a.txt");
//        System.out.println("创建文件"+file.createNewFile());
        System.out.println("删除文件或者文件夹"+file.delete());
//        System.out.println("创建由此File表示的目录"+file.mkdir());
//        System.out.println("创建由此File表示任何必需但不存在的父目录"+file.mkdirs());
    }
}
