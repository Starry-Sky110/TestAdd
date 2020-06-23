package ThreadLearn;

public class ThreadMethod {

    public static void main(String[] args) {
        //线程命名
        //1.实例化一个线程对象
//        Thread t1 = new Thread();
//        t1.setName("1号线程");
//        //2.构造方法里
//        Thread t2 = new Thread("2号线程");
//        //3.自定义
//        MyThread2 t3 = new MyThread2("3号线程");

//        System.out.println(t3.getName());

        //线程休眠sleep不会释放锁
//        threadSleep();
        //线程优先级
        Thread t1 = new Thread(new MyRunnable2());
        Thread t2 = new Thread(new MyRunnable2());
        t1.setName("1");
        t2.setName("2");
        //线程优先级默认为5
        //必须在start()之前
        //优先级为1-10   数字越大优先级越高只是抢到cpu概率更高
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();

    }


    private static void threadSleep() {
        MyThread2 thread2 = new MyThread2();
        thread2.start();
    }

}

class MyThread2 extends Thread {
    public MyThread2() {
    }

    public MyThread2(String name) {
//        super(name);
        this.setName(name);
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程为" + Thread.currentThread().getName() + "输出数字：" + i);

        }
    }
}
