package test11_objects_date_dateformat_calendar_system_stringbuilder.system.example;
//验证for循环打印数字1-9999所需要使用的时间（毫秒）
public class Example01 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <10000 ; i++) {
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"毫秒");
    }
}
