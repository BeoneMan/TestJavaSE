package test20_inputstream_outputstream_reader_writer.properties;

import javax.xml.transform.Source;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
构造方法
    public Properties() :创建一个空的属性列表。

基本的存储方法
    public Object setProperty(String key, String value) ： 保存一对属性。
    public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值。
    public Set<String> stringPropertyNames() ：所有键的名称的集合。
 */
public class PropertiesDemo01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name","张胜男");
        properties.setProperty("age","18");
        String name = properties.getProperty("name");
        System.out.println(name);
        System.out.println("--------");
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key+":"+properties.get(key));
        }

        try (FileWriter fw = new FileWriter("C:\\Users\\Administrator\\Desktop\\a.properties")) {
            properties.store(fw,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
