package test15_map.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo01 {
    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("邓超","孙俪");
        linkedHashMap.put("李晨","范冰冰");
        linkedHashMap.put("刘德华","朱丽倩");
        Set<Map.Entry<String, String>> entries = linkedHashMap.entrySet();
        for (Map.Entry<String, String> map:entries){
            System.out.println(map.getKey()+":"+map.getValue());
        }
    }
}
