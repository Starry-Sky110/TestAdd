package producerAndConsumer;

public class Program {
    //生产者
    /*
    作用是生产产品
    通过一个判断是否需要生产产品
    如果需要生产，生产产品，并通知消费者
    如果不需要生产，等待
     */
    /*
    作用是消费产品
    消费逻辑，判断是否有足够的产品消费
    如果可以消费，获取产品
    如果不可以消费，等待
     */

    public static void main(String[] args) {
        ProductPool productPool = new ProductPool(15);
        new Producer(productPool).start();
        new Consumer(productPool).start();
    }

}
