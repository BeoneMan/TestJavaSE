package reflect;

import org.junit.Test;

/**
 * 获取Class对象的方式：
 *     1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
 *         * 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
 *     2. 类名.class：通过类名的属性class获取
 *         * 多用于参数的传递
 *     3. 对象.getClass()：getClass()方法在Object类中定义着。
 *         * 多用于对象的获取字节码的方式
 */
public class ReflectDemo01 {
    @Test
    public void test() throws ClassNotFoundException {
        //多用于配置文件中
        Class<ReflectDemo01> a1 = (Class<ReflectDemo01>) Class.forName("reflect.ReflectDemo01");
        //多用于参数传递中
        Class<ReflectDemo01> a2 = ReflectDemo01.class;
        //多用于对象获取字节码的方式
        Class<? extends ReflectDemo01> a3 = new ReflectDemo01().getClass();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a1==a2?(a1==a3?true:false):false);
    }
}
