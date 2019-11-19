package test08_string_static_arrays_math.arrays;

import java.util.Arrays;

//请使用 Arrays 相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。
//String line = "ysKUreaytWTRHsgFdSAoidq";
public class ArrayDemo02 {
    public static void main(String[] args) {
        String line = "ysKUreaytWTRHsgFdSAoidq";
        char[] chars = line.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = chars.length - 1; i > 0; i--) {
            if (i == 0) sb.append(chars[i]).append("]").toString();
            sb.append(chars[i]).append(",");
        }
        System.out.println(sb.toString());
    }
}
