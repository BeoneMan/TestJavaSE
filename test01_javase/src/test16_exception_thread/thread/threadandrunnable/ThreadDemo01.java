package test16_exception_thread.thread.threadandrunnable;
/**
 * 继承Thread类实现多线程
 */

import org.junit.Test;

public class ThreadDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread()+":"+i);
        }
    }


    @Test
    public void test01(){
        ThreadDemo01 td = new ThreadDemo01();
        td.start();
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread()+":"+i);
        }

    }
}

