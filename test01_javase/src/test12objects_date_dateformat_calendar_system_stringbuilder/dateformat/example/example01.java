package test12objects_date_dateformat_calendar_system_stringbuilder.dateformat.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//请使用日期时间相关的API，计算出一个人已经出生了多少天。
public class example01 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取我出生的日期毫秒值
        long myBirthTime = sdf.parse("1994-07-08").getTime();

        //获取当前日期的毫秒值然后相减
        long resultTime = new Date().getTime()-myBirthTime;
        //天数
       int day=(int)(resultTime/1000/60/60/24) ;
        System.out.println("我出生到现在已经有"+day+"天了");
    }
}
