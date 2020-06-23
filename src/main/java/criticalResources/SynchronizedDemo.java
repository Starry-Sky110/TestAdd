package criticalResources;

import javax.print.attribute.HashAttributeSet;
import java.util.*;

public class SynchronizedDemo {

    /**
     * 同步代码段
     *
     * @param args
     */
    public static void main(String[] args) {
        //实例化四个售票员,四个线程模拟
        Runnable r = () -> {
            while (TicketCenter.restCount > 0) {
                //对象锁:任意的对象
                //类锁 SynchronizedDemo.class也可以
                //需要保证一点，多个线程看到的锁需要时通一把锁

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
