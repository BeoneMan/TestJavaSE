package test08_string_static_arrays_math.string;

public class StringDemo02 {

    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = "World";
        String str3 = "hello";


//      判断功能
//      public boolean equals (Object anObject) ：将此字符串与指定对象进行比较。
//      public boolean equalsIgnoreCase (String anotherString) ：将此字符串与指定对象进行比较，忽略大小写。
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str3));
        System.out.println("--------");

//        获取功能的方法
//        public int length () ：返回此字符串的长度。
//        public String concat (String str) ：将指定的字符串连接到该字符串的末尾。
//        public char charAt (int index) ：返回指定索引处的 char值。
//        public int indexOf (String str) ：返回指定子字符串第一次出现在该字符串内的索引。
//        public String substring (int beginIndex) ：返回一个子字符串，从beginIndex开始截取字符串到字符 串结尾。
//        public String substring (int beginIndex, int endIndex) ：返回一个子字符串，从beginIndex到 endIndex截取字符串。含beginIndex，不含endIndex。
        System.out.println("Hello字符串的长度:" + str1.length());
        System.out.println("Hello拼接Java:" + str1.concat("Java"));
        System.out.println("Hello索引值1的值：" + str1.charAt(1));
        System.out.println("Hello中的l第一次出现在该字符串内的索引:" + str1.indexOf("l"));
        System.out.println("Hello从2索引开始截取字符串到字符串结尾：" + str1.substring(2));
        System.out.println("Hello从2索引开始截取字符串到4索引结尾：" + str1.substring(2, 4));//包左不包右
        System.out.println("--------");


//        转换功能的方法
//        public char[] toCharArray () ：将此字符串转换为新的字符数组。
//        public byte[] getBytes () ：使用平台的默认字符集将该 String编码转换为新的字节数组。
//        public String replace (CharSequence target, CharSequence replacement) ：将与target匹配的字符串使 用replacement字符串替换。
        char[] chars = str1.toCharArray();
        System.out.println("char数组:" + chars[0]);
        byte[] bytes = str1.getBytes();
        System.out.println("bytes数组:" + bytes[0]);
        str1.replace("H", "h");
        System.out.println(str1);
        System.out.println("--------");

//        分割功能的方法
//        public String[] split(String regex) ：将此字符串按照给定的regex（规则）拆分为字符串数组。
        String[] strArray = "hello_java_你好".split("_");
        for (String s : strArray) {
            System.out.println(s);
        }
    }

}
