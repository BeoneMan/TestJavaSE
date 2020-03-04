package test21_buffered_others.InputSreamReader_OutputSreamWriter;

import java.io.*;

public class InputStreamReaderDemo01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\gbk.txt");
        InputStreamReader isr = null;
        try {
            //���Դ
//            isr = new InputStreamReader(new FileInputStream(file));
            isr = new InputStreamReader(new FileInputStream(file),"gbk");
            int len = 0;
            char[] chars = new char[1024];
            while ((len = isr.read(chars)) != -1) {
                System.out.println(new String(chars, 0, chars.length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
