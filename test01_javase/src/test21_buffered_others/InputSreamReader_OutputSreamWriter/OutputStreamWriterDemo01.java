package test21_buffered_others.InputSreamReader_OutputSreamWriter;

import java.io.*;

public class OutputStreamWriterDemo01 {
    public static void main(String[] args) {
        File file = null;
        OutputStreamWriter osw = null;
        try {
            file = new File("C:\\Users\\Administrator\\Desktop\\utf-8.txt");
            osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write("邱佳源");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (osw != null) osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
