package test23_functionalinterface.diy;

/**
 *自定义函数接口
 * 有了@FunctionalInterface就能保证接口中只有一个抽象方法，否则程序在编译期就会报错
 */
@FunctionalInterface
public interface DiyFunctionalInterfaceDemo02 {
    void mymethod();
//    void eat();
}
