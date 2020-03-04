package test21_buffered_others.objectoutputstream_objectinputstream;

import java.io.*;
import java.util.Date;

public class ObjectOutputStreamDemo01 {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop\\object.txt");
            oos = new ObjectOutputStream(new FileOutputStream(file));
            Employee employee = new Employee(18, "小邱", new Date());

            oos.writeObject(employee);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
