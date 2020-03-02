package test16_exception_thread.thread.synchronizeds;

/**
 * 我们来模拟电影院的售票窗口，实现多个窗口同时卖 “葫芦娃大战奥特曼”这场电影票
 * (多个窗口一起卖这100张票)
 * 需要窗口，采用线程对象来模拟；需要票，Runnable接口子类来模拟
 */
public class TicketSell01 implements Runnable {
    private Integer ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖第" + ticket-- + "张票");

            }
            else{break;}

        }
    }
}

class Test {
    public static void main(String[] args) {
        TicketSell01 ts = new TicketSell01();
        Thread td1 = new Thread(ts, "窗口一");
        Thread td2 = new Thread(ts, "窗口二");
        Thread td3 = new Thread(ts, "窗口三");
        td1.start();
        td2.start();
        td3.start();
    }
}
