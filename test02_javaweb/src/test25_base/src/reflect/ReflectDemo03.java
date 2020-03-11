package reflect;

import org.junit.Test;
import reflect.entity.Entity01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * * Field：成员变量
 *     * 操作：
 *         1. 设置值
 *             * void set(Object obj, Object value)
 *         2. 获取值
 *             * get(Object obj)
 *
 *         3. 忽略访问权限修饰符的安全检查
 *             * setAccessible(true):暴力反射
 *
 *
 *
 * * Constructor:构造方法
 *     * 创建对象：
 *         * T newInstance(Object... initargs)
 *
 *         * 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
 *
 *
 * * Method：方法对象
 *     * 执行方法：
 *         * Object invoke(Object obj, Object... args)
 *
 *     * 获取方法名称：
 *         * String getName:获取方法名
 */
public class ReflectDemo03 {
  /*  Field：成员变量
    操作：
    1.设置值
        void set(Object obj, Object value)
    2.获取值
        get(Object obj)
    3.忽略访问权限修饰符的安全检查
        setAccessible(true):暴力反射*/

    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /** Constructor:构造方法
                * 创建对象：
                * T newInstance(Object... initargs)
        * 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法*/

        Class<Entity01> entity01Class = Entity01.class;
//        Entity01 entity01 = new Entity01(new Date());
        Constructor<Entity01> declaredConstructor = entity01Class.getDeclaredConstructor();
        //忽略访问权限修饰符的安全检查
        declaredConstructor.setAccessible(true);
        Entity01 entity01 = declaredConstructor.newInstance();
        Field  privateNameField = entity01Class.getDeclaredField("privateName");
        //忽略访问权限修饰符的安全检查
        privateNameField.setAccessible(true);
        privateNameField.set(entity01,"私有值");
        String s = (String)privateNameField.get(entity01);
        System.out.println(s);

        System.out.println("-------");
        Method setPrivateNameMethod = entity01Class.getDeclaredMethod("setPrivateName", String.class);
        //忽略访问权限修饰符的安全检查
        setPrivateNameMethod.setAccessible(true);
        setPrivateNameMethod.invoke(entity01,"更改后私有值");

        Method getPrivateNameMethod = entity01Class.getDeclaredMethod("getPrivateName");
        String name = String.valueOf(getPrivateNameMethod.invoke(entity01));
        System.out.println(name);

    }
}
