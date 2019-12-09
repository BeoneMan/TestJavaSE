package test12objects_date_dateformat_calendar_system_stringbuilder.stringbuilder;

public class StringBuilderDemo01 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String s = sb.append("hello").append("_").append("java").toString();
        System.out.println(s);

    }
}
