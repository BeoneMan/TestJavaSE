package test17_thread_synchronized.synchronizeds;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用锁机制解决同步问题
 */
public class TicketSell04 implements Runnable {
    private Integer ticket = 100;
   Lock lock= new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖第" + ticket-- + "张票");
                lock.unlock();
            } else {
                lock.unlock();
                break;
            }


        }
    }
}

class Test04 {
    public static void main(String[] args) {
        TicketSell04 ts = new TicketSell04();
        Thread td1 = new Thread(ts, "窗口一");
        Thread td2 = new Thread(ts, "窗口二");
        Thread td3 = new Thread(ts, "窗口三");
        td1.start();
        td2.start();
        td3.start();
    }
}
