package test02_datatypeconversion_operator_method.operator;

/**
 * 逻辑运算符
 * &&
 * ||
 * !
 * ^
 */
public class LogicalOperator {
    public static void main(String[] args) {
        System.out.println(true ^ true);  //false
        System.out.println(true ^ false); //true
        System.out.println(false ^ true); //true
        System.out.println(false ^ false);//false
    }
}
