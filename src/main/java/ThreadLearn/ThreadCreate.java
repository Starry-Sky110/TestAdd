package ThreadLearn;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

public class ThreadCreate {


    public static void main(String[] args) {
        // 线程实例化
        //1.继承Thread类，做一个线程子类（自定义的线程类）
        MyThread t1 = new MyThread();
        //start会开启一个新的线程，来执行run中的逻辑
        //如果直接调用run方法，则线程mt不会进入就绪态
        t1.start();

        Runnable r1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程2中的逻辑：" + i);
            }
        };
        Thread t2 = new Thread(r1);
        t2.start();

        Thread t3 = new Thread(new MyRunnable());
        t3.start();



        System.out.println("主线程中的逻辑执行结束了");
    }
}

/**
 * 继承Thread
 */
class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1中的逻辑:" + i);
        }
    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程3中的逻辑:" + i);
        }
    }
}