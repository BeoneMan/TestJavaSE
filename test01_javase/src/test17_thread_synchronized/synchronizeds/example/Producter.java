package test17_thread_synchronized.synchronizeds.example;

/**
 * 生产者
 */
public class Producter implements Runnable {
    private BaoZi baozi;

    public Producter(BaoZi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (baozi) {
                if (baozi.getStatus()) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("正在生产包子");
                    if (count % 2 == 0) {
                        baozi.setPier("凉皮");
                        baozi.setXianer("凉馅");
                    } else {
                        baozi.setPier("热皮");
                        baozi.setXianer("热馅");
                    }
                    ++count;
                    baozi.setStatus(true);
                    baozi.notify();
                }
            }
        }
    }
}
