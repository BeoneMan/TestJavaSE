package test17_thread_synchronized.synchronizeds.example;

public class TestDemo {
    public static void main(String[] args) {
        BaoZi baozi=new BaoZi();
        Producter producter = new Producter(baozi);
        Consumer consumer = new Consumer(baozi);
        Thread td1=new Thread(producter);
        Thread td2=new Thread(consumer);
        td1.start();
        td2.start();
    }
}
