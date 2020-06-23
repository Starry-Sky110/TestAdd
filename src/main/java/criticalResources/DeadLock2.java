package criticalResources;

public class DeadLock2 {

    public static void main(String[] args) {

        //wait，Object中的一个方法,当前的线程释放自己的锁标记，并让出cpu资源，使得当前的线程进入等待队列中
        //notify：通知，是Object类中的方法，唤醒等待队列中的一个线程，使这个线程进入锁池
        //notifyAll:是Object中的一个方法，唤醒等待队列中的所有线程，并进入锁池

        Runnable r1 = () -> {
            synchronized ("A") {
                System.out.println("A线程持有了A锁，等待B锁");
                //释放已经持有的A锁标记
                try {
                    "A".wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized ("B") {
                    System.out.println("A线程持有了A，B锁");
                }
            }
        };

        Runnable r2 = () -> {
            synchronized ("B") {
                System.out.println("B线程持有了B锁，等待A锁");

                synchronized ("A") {
                    System.out.println("B线程持有了A，B锁");
                    "A".notify();
                }
            }

        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
