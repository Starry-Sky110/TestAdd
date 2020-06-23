package ThreadLearn;

public class ThreadYield {

    /**
     * 线程礼让，指是让当前运行状态的线程释放自己的cpu资源，
     * 由运行状态回到就绪状态
     *
     * @param args
     */

    public static void main(String[] args) {

        Runnable r1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i == 3) {
                    Thread.yield();
                }
            }
        };

        Thread t1 = new Thread(r1, "Thread1");
        Thread t2 = new Thread(r1, "Thread2");
        t1.start();
        t2.start();
    }

}

