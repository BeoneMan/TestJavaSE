package test15_map.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo02 {
    public static void main(String[] args) {
        Map<String, Student> hashMap = new HashMap<String, Student>();
        hashMap.put("三张",new Student("张三",18));
        hashMap.put("李四",new Student("李四",19));
        hashMap.put("五王",new Student( "五王",20));
        System.out.println(hashMap);
        System.out.println("--------");


        Student getValue = hashMap.get("三张");
        System.out.println(getValue);
        System.out.println("--------");

        Set<String> stringSet = hashMap.keySet();
        for (String key : stringSet) {
            Student value = hashMap.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println("--------");

        Set<Map.Entry<String, Student>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, Student> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
