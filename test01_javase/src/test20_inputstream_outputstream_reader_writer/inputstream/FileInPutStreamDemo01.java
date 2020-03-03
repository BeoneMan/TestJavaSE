package test20_inputstream_outputstream_reader_writer.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInPutStreamDemo01 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Administrator\\Desktop\\b.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
//            int read = fis.read();
//            System.out.println((char)read);
            byte[] bytes = new byte[1024];
//            int read = fis.read(bytes);
//            System.out.println(read);
            int i=0;
            while((i=fis.read(bytes))!=-1){
                System.out.println(new String(bytes,0,i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
