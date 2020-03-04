package test21_buffered_others.objectoutputstream_objectinputstream.example;

import java.io.Serializable;
import java.util.Date;

/**
 * 序列化
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 7351017508245332150L;
    Integer age;
    String name;
     Date birthday;

    public Student() {
    }

    public Student(Integer age, String name, Date birthday) {
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
