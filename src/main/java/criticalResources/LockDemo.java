package criticalResources;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    /**
     * 实例化了一个锁对象
     */
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //实例化四个售票员,四个线程模拟
        Runnable r = () -> {
            while (TicketCenter.restCount > 0) {
                lock.lock();
                if (TicketCenter.restCount <= 0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + ":卖出一张票:票剩余：" + --TicketCenter.restCount);
                lock.unlock();
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
