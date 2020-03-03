package test20_inputstream_outputstream_reader_writer.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\c.txt");
        FileWriter fw = null ;
        try {
            fw = new FileWriter(file, true);
            fw.write("driveman真帅啊");
            fw.write("\r\n");
//            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw!=null)fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
