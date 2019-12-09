package test12objects_date_dateformat_calendar_system_stringbuilder.calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo01 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);

        //get方法用来获取指定字段的值，set方法用来设置指定字段的值
        int year = instance.get(Calendar.YEAR);
        System.out.println(year);

        int year2 = instance.get(1);
        System.out.println(year2);

        int month = instance.get(instance.MONTH) + 1; //从0开始计算 所以需要+1
        int day = instance.get(instance.DAY_OF_MONTH);
        int weekDay = instance.get(Calendar.DAY_OF_WEEK) - 1;//西方星期的开始为周日，中国为周一
        System.out.println(year + "年" + month + "月" + day + "日 星期" + weekDay);


        Date calendarDate = instance.getTime();//Calendar类中getTime()获取的Date对象，并不是毫秒值
        System.out.println(calendarDate);

    }


}
