package test23_functionalinterface.common;

import java.util.function.Supplier;

public class SupplierDemo01 {
    public static void main(String[] args) {
        String s1 = "hello" ;
        String s2 = "world" ;
        System.out.println(getMessage(1,()->s1+s2));
    }
    public static String getMessage(Integer level , Supplier<String> sl){
        if(level==1)return sl.get();
        return null;
    }
}
