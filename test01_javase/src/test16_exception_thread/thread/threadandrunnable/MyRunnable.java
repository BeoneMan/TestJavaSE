package test16_exception_thread.thread.threadandrunnable;
/**
 * 实现Runnable接口实现多线程
 */

import org.junit.Test;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }

    @Test
    public void test01() {
        MyRunnable td2 = new MyRunnable();
        Thread thread = new Thread(td2);
        thread.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }
}
