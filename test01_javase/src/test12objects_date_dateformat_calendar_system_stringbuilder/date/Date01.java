package test12objects_date_dateformat_calendar_system_stringbuilder.date;

import java.util.Date;

public class Date01 {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);//Wed Nov 20 14:18:28 CST 2019
        long time = date.getTime();
        System.out.println(time);
        System.out.println("--------");

        Date date2=new Date(0);
        System.out.println(date2);//Thu Jan 01 08:00:00 CST 1970

        long time2 = date2.getTime();
        System.out.println(time2);

    }
}
