package test21_buffered_others.bufferedreader_bufferedwriter;

import java.io.*;
import java.util.HashMap;

/**
 * 练习:文本排序
 */
public class demo01 {
    public static void main(String[] args) {
        File srcFile = new File("F:\\IdeaProjects\\testjava\\test01_javase\\src\\test21_buffered_others\\bufferedreader_bufferedwriter\\a.txt");
        File getFile = new File("F:\\IdeaProjects\\testjava\\test01_javase\\src\\test21_buffered_others\\bufferedreader_bufferedwriter\\b.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(getFile));
            String s = null;
            while ((s = br.readLine()) != null) {
                String[] strings = s.split("\\.");
                hashMap.put(strings[0], strings[1]);

            }

            for (int i = 1; i <= hashMap.size(); i++) {
                String value = hashMap.get(String.valueOf(i));
                bw.write(i + "." + value);
                bw.newLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
