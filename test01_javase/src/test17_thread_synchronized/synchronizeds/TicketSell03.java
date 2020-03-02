package test17_thread_synchronized.synchronizeds;

/**
 * 使用同步方法解决同步问题
 */
public class TicketSell03 implements Runnable {
    private Integer ticket = 100;

    @Override
    public void run() {
        while (true) {
          sell();
            if (ticket <= 0)break;
        }
    }

    private synchronized void sell() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String name = Thread.currentThread().getName();
            System.out.println(name + "正在卖第" + ticket-- + "张票");
        }
    }
}

class Test03 {
    public static void main(String[] args) {
        TicketSell03 ts = new TicketSell03();
        Thread td1 = new Thread(ts, "窗口一");
        Thread td2 = new Thread(ts, "窗口二");
        Thread td3 = new Thread(ts, "窗口三");
        td1.start();
        td2.start();
        td3.start();
    }
}
