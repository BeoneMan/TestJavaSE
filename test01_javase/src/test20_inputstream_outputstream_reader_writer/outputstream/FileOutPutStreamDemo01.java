package test20_inputstream_outputstream_reader_writer.outputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamDemo01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\a.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
          /*  fos.write(97);
            fos.write(98);
            fos.write(99);*/
            byte[] bytes = "driveman_邱佳源".getBytes();
//            fos.write(bytes);
            fos.write(bytes,9,9);
            fos.write(bytes,0,8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
