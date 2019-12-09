package test15_map.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
    public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的 值。
    public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
    public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。
    public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。
 */
public class MapDemo01 {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("张三", "三张");
        hashMap.put("李四", "李四");
        hashMap.put("王五", "五王");
        System.out.println(hashMap);
        System.out.println("--------");

        String removeValue = hashMap.remove("王五");
        System.out.println(removeValue);
        System.out.println("--------");

        String getValue = hashMap.get("李四");
        System.out.println(getValue);
        System.out.println("--------");

        Set<String> stringSet = hashMap.keySet();
        for (String key : stringSet) {
            String value = hashMap.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println("--------");

        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
