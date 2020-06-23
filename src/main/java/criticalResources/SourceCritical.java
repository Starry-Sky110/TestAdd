package criticalResources;

public class SourceCritical {

    //临界资源问题
    //某个景点有四个售票员在同时售票，票为临界资源
    public static void main(String[] args) {
        //实例化四个售票员,四个线程模拟
        Runnable r = () -> {
            while (TicketCenter.restCount > 0) {
                synchronized ("str") {
                    if (TicketCenter.restCount > 0) {
                        System.out.println(Thread.currentThread().getName() + ":卖出一张票:票剩余：" + --TicketCenter.restCount);

                    }
                }
            }
        };
        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");
        Thread t3 = new Thread(r, "Thread3");
        Thread t4 = new Thread(r, "Thread4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class TicketCenter1 {
    //描述剩余票的数量
    public static int restCount = 100;

}
