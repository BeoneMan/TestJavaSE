package test02_datatypeconversion_operator_method.datatypeconversion;

/**
 * 当一个 short 类型与 1 相加，我们知道会类型提升，
 * 但是还想给结果赋值给short类型变量，就需要强制转换。
 */
public class CastConversion {
    public static void main(String[] args) {
        short s = 1;
        short s2 = 2;
//        s = (short)(s + s2);
        s = (short) (s + 1);//s+1计算会自动提升为int类型
        System.out.println(s);

        //总结： byte、short、char 运算时直接提升为 int
    }
}
