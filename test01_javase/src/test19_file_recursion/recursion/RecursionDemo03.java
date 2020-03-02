package test19_file_recursion.recursion;

import java.io.File;

/**
 * 搜索多级目录下是否包含.java文件
 */
public class RecursionDemo03 {
    public static void main(String[] args) {
        File file = new File("F:\\IdeaProjects\\testjava\\test01_javase\\src\\test19_file_recursion");
        printFile(file);
    }

    private static void printFile(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        String name = f.getName();
                        if (name.endsWith(".java")) {
                            System.out.println(name);
                        }
                    } else {
                        printFile(f);
                    }
                }
            }
        }
    }
}
