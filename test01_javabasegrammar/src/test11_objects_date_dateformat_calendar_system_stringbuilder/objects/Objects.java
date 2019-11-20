package test11_objects_date_dateformat_calendar_system_stringbuilder.objects;

public class Objects {
    public static void main(String[] args) {
/*        String a="小三";
        String b="小四";

        boolean equals = java.util.Objects.equals(a, b);
        System.out.println(equals);
        System.out.println("--------");*/

        Person p1 = new Person("xiao01");
        Person p2 = new Person("xiao01");
        boolean personEquals = java.util.Objects.equals(p1, p2);//Person类重写了equals（）方法
        System.out.println(personEquals);
        System.out.println("--------");
//        public static boolean equals(Object a, Object b) {
//            return (a == b) || (a != null && a.equals(b));
//        }
        String p1ToString = java.util.Objects.toString(p1);
        System.out.println(p1ToString);
     /*   public static String toString(Object o) {
            return String.valueOf(o);
        }*/
    }
}
