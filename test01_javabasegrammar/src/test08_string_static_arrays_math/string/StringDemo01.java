package test08_string_static_arrays_math.string;

public class StringDemo01 {
    public static void main(String[] args) {
        //1. 字符串不变：字符串的值在创建后不能被更改。
        String str1 = "Hello";

//        2. 因为String对象是不可变的，所以它们可以被共享。
        String str2 = "Hello"; //在常量池中创建字符串对象
        String str3 = "Hello";
        System.out.println(str2 == str3);//在常量池中比较  true

        String str4 = new String("Hello");//在堆中创建字符串对象
        System.out.println(str2 == str4);

//        3. "abc" 等效于 char[] data={ 'a' , 'b' , 'c' } 。
        char[] data = {'H', 'e', 'l', 'l', 'o'};
        String str5 = new String(data);
        System.out.println(str5);//Hello
        System.out.println(str5 == str2);//false


    }

}
