package test21_buffered_others.objectoutputstream_objectinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo01 {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop\\object.txt");
            ois = new ObjectInputStream(new FileInputStream(file));
            Employee o = (Employee) ois.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
