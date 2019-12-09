package test02_datatypeconversion_operator_method.operator;

/**
 * 和其他变量放在一起， 前++ 和 后++ 就产生了不同
 */
public class CountOperator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a++);//10 !!!!!!
        System.out.println(++a);//12
        System.out.println(b++);//20 !!!!!!
        System.out.println(++b);//22


    }

}
