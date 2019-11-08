package test02_datatypeconversion_operator_method.operator;

//赋值
public class AssigningOperator {
    public static void main(String[] args) {
        int i = 1000;
        i += 1;
        System.out.println(i);//1001
        i -= 1;
        System.out.println(i);//1000
        i *= 10;
        System.out.println(i);//10000
        i /= 10;
        System.out.println(i);//1000
        i %= 100;//取余数
        System.out.println(i);//0 !!!!!!


    }
}
