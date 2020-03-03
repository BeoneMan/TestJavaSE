package test20_inputstream_outputstream_reader_writer.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamDemo02 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\b.txt", true)) {
            byte[] bytes = "driveman最帅".getBytes();
            fos.write(bytes);
            fos.write("\r\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
