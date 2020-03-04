package test21_buffered_others.InputSreamReader_OutputSreamWriter;

import java.io.*;

/**
 * 将GBK编码的文本文件，转换为UTF-8编码的文本文件。
 * 案例分析
 * 1. 指定GBK编码的转换流，读取文本文件。
 * 2. 使用UTF-8编码的转换流，写出文本文件。
 */
public class TransformationDemo01 {
    public static void main(String[] args) {
        File srcFile = new File("C:\\Users\\Administrator\\Desktop\\gbk.txt");
        File getFile = new File("C:\\Users\\Administrator\\Desktop\\utf-8.txt");
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new FileInputStream(srcFile), "gbk");
            osw = new OutputStreamWriter(new FileOutputStream(getFile), "utf-8");

            char[] chars = new char[1024];
            int len = 0;
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) osw.close();
                if (isr != null) isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
