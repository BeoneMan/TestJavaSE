package test16_exception_thread.thread.synchronizeds.example;

/**
 * 消费者
 */
public class Consumer implements Runnable {
    private BaoZi baozi;

    public Consumer(BaoZi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baozi) {
                if (baozi.getStatus()) {
                    System.out.println("吃包子" + baozi);
                    baozi.setStatus(false);
                    baozi.notify();
                } else {
                    System.out.println("没有包子吃");
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
