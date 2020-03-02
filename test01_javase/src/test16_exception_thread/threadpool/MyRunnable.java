package test16_exception_thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("我要一个线程");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "线程拿到了");
        System.out.println(Thread.currentThread().getName() + "线程归还了");
    }
}

class Test {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
    }
}
