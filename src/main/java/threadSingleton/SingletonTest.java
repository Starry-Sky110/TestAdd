package threadSingleton;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

public class SingletonTest {

    public static void main(String[] args) {

        Runnable r = () -> {
            Boss.getBoss();
        };


        for (int i = 0; i < 1000; i++) {
            new Thread(r).start();
        }
    }

}

//懒汉式
class Boss {
    private Boss() {
        System.out.println("一个Boss对象被实例化了");
    }

    private static Boss Instance = null;

    //这样改写或者改成同步方法
    public static Boss getBoss() {
        synchronized (""){
            if (Instance == null) {
                Instance = new Boss();
            }
        }
        return Instance;
    }
}