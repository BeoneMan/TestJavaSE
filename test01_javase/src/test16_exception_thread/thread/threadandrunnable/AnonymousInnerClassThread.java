package test16_exception_thread.thread.threadandrunnable;

/**
 * 使用匿名内部类实现多线程
 */
public class AnonymousInnerClassThread {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread() + ":" + i);
                }
            }
        };
        new Thread(runnable, "driveman").start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }
}
