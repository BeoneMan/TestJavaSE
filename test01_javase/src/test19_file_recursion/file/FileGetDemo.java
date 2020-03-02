package test19_file_recursion.file;

import java.io.File;

/**
 * public String getAbsolutePath() ：返回此File的绝对路径名字符串。
 * public String getPath() ：将此File转换为路径名字符串。
 * public String getName() ：返回由此File表示的文件或目录的名称。
 * public long length() ：返回由此File表示的文件的长度。
 */
public class FileGetDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\未标题-1.jpg");
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath:" + absolutePath);
        String path = file.getPath();
        System.out.println("path:" + path);
        String name = file.getName();
        System.out.println("name:" + name);
        long length = file.length();
        System.out.println("lenth:" + length);
    }

}
