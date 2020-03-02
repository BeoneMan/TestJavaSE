package test16_exception_thread.thread.synchronizeds;

/**
 * 使用同步代码块解决同步问题
 */
public class TicketSell02 implements Runnable {
    private Integer ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖第" + ticket-- + "张票");

                } else {
                    break;
                }

            }


        }
    }
}

class Test02 {
    public static void main(String[] args) {
        TicketSell02 ts = new TicketSell02();
        Thread td1 = new Thread(ts, "窗口一");
        Thread td2 = new Thread(ts, "窗口二");
        Thread td3 = new Thread(ts, "窗口三");
        td1.start();
        td2.start();
        td3.start();
    }
}
