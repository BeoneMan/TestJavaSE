package reflect;

import org.junit.Test;
import reflect.entity.Entity01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 *  Class对象功能：
 *     * 获取功能：
 *         1. 获取成员变量们
 *             * Field[] getFields() ：获取所有public修饰的成员变量
 *             * Field getField(String name)   获取指定名称的 public修饰的成员变量
 *
 *             * Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
 *             * Field getDeclaredField(String name)
 *         2. 获取构造方法们
 *             * Constructor<?>[] getConstructors()
 *             * Constructor<T> getConstructor(类<?>... parameterTypes)
 *
 *             * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 *             * Constructor<?>[] getDeclaredConstructors()
 *         3. 获取成员方法们：
 *             * Method[] getMethods()
 *             * Method getMethod(String name, 类<?>... parameterTypes)
 *
 *             * Method[] getDeclaredMethods()
 *             * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 *
 *         4. 获取全类名
 *             * String getName()
 */
public class ReflectDemo02 {
/*     1. 获取成员变量们
             Field[] getFields() ：获取所有public修饰的成员变量
             Field getField(String name)   获取指定名称的 public修饰的成员变量
             Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
             Field getDeclaredField(String name)*/

     @Test
     public void testField() throws NoSuchFieldException {
         Class<Entity01> entity01Class = Entity01.class;
       /*  Field[] fields = entity01Class.getFields();
         for (Field field : fields) {
             System.out.println(field.getName());
         }*/

       /*  Field birthday02 = entity01Class.getField("birthday02");
           System.out.println(birthday02);*/

        /* Field[] declaredFields = entity01Class.getDeclaredFields();
         for (Field declaredField : declaredFields) {
             System.out.println(declaredField.getName());
         }*/


         Field fieldSex = entity01Class.getDeclaredField("sex");
         System.out.println(fieldSex);


     }

/*      2. 获取构造方法们
         * Constructor<?>[] getConstructors()
         * Constructor<T> getConstructor(类<?>... parameterTypes)
         * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         * Constructor<?>[] getDeclaredConstructors()*/
        @Test
        public void testConstructor() throws ClassNotFoundException {
            Class<Entity01> entity01Class = (Class<Entity01>) Class.forName("reflect.entity.Entity01");
          /*  Constructor<?>[] constructors = entity01Class.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }*/

            Constructor<?>[] declaredConstructors = entity01Class.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

        }

       /*  3. 获取成员方法们：
        * Method[] getMethods()
        * Method getMethod(String name, 类<?>... parameterTypes)
        * Method[] getDeclaredMethods()
        * Method getDeclaredMethod(String name, 类<?>... parameterTypes)*/

       @Test
    public void testMethod(){
           Class<? extends Entity01> entity01Class = new Entity01(new Date()).getClass();
           Method[] methods = entity01Class.getMethods();
           for (Method method : methods) {
               System.out.println(method);
           }
           System.out.println("--------");
           Method[] declaredMethods = entity01Class.getDeclaredMethods();
           for (Method declaredMethod : declaredMethods) {
               System.out.println(declaredMethod);
           }
       }
}
