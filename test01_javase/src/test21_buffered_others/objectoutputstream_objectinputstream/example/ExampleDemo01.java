package test21_buffered_others.objectoutputstream_objectinputstream.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * 练习：序列化集合
 * 1. 将存有多个自定义对象的集合序列化操作，保存到 list.txt 文件中。
 * 2. 反序列化 list.txt ，并遍历集合，打印对象信息。
 * 案例分析
 * 1. 把若干学生对象 ，保存到集合中。
 * 2. 把集合序列化。
 * 3. 反序列化读取时，只需要读取一次，转换为集合类型。
 * 4. 遍历集合，可以打印所有的学生信息
 */
public class ExampleDemo01 {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois= null ;
        try {
            ArrayList<Student> arrays = new ArrayList<>();
            arrays.add(new Student(20,"小",new Date()));
            arrays.add(new Student(23,"电",new Date()));
            arrays.add(new Student(12,"点睡",new Date()));
            arrays.add(new Student(210,"发",new Date()));
            File file = new File("list.txt");
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(arrays);
             ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Student> stuArrays = (ArrayList<Student>)ois.readObject();
            for (Student s : stuArrays) {
                System.out.println(s);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(oos!=null)oos.close();
                if(ois!=null)ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
