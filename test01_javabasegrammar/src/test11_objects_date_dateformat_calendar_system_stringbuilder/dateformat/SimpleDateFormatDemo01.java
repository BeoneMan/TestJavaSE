package test11_objects_date_dateformat_calendar_system_stringbuilder.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo01 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = sdf.format(new Date());
        System.out.println(formatDate);
        System.out.println("--------");

        String s=formatDate;
        Date parseDate = sdf.parse(s);
        System.out.println(parseDate);
    }
}
