package test15_map.map.example;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 需求：
 * 计算一个字符串中每个字符出现次数。
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String s = scanner.next();
        Map map = new Demo01().getCharCount(s);
        System.out.println(map);
    }

    public Map getCharCount(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Integer i = hashMap.get(c);
            if (i != null) {
                hashMap.put(c, ++i);
            } else {
                hashMap.put(c, 1);
            }
        }
        return hashMap;
    }
}
