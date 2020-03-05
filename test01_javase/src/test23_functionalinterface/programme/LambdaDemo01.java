package test23_functionalinterface.programme;

import java.util.logging.Level;

/**
 * lambda有延迟作用
 *
 * 性能浪费的日志案例
 * 注:日志可以帮助我们快速的定位问题，记录程序运行过程中的情况，以便项目的监控和优化。
 * 一种典型的场景就是对参数进行有条件使用，例如对日志消息进行拼接后，在满足条件的情况下进行打印输出：
 */
public class LambdaDemo01 {
    /*
    这段代码存在问题：无论级别是否满足要求，作为 log 方法的第二个参数，
    三个字符串一定会首先被拼接并传入方法内，然后才会进行级别判断。
    如果级别不符合要求，那么字符串的拼接操作就白做了，存在性能浪费。

     */
    public static void main(String[] args) {
        String s1 = "hello" ;
        String s2 = "world" ;
        log01(2,s1+s2);
        log02(2,()-> s1+s2);
    }
    public static void log01(Integer level ,String s){
        if(level==1) System.out.println(s);

    }

    public static void log02(Integer level ,LambdaLogger ll){
        if(level==1) System.out.println(ll.getMessage());

    }

}
