package producerAndConsumer;

import java.util.LinkedList;
import java.util.List;

public class ProductPool {
    //存商品仓库producer生产进入 consumer消费
    private List<Product> productList;

    private int maxSize = 0;

    public ProductPool(int maxSize) {
        this.productList = new LinkedList<>();
        this.maxSize = maxSize;
    }

    //生产者产出放入仓库
    public synchronized void push(Product product) {
        //判断是否还需要再生产
        if (this.productList.size() == maxSize) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //将产品添加到集合中
        this.productList.add(product);
        //通知其他人，有产品消费
        this.notifyAll();

    }

    //消费者拿商品
    public synchronized Product pop() {
        //判断是否有商品消费
        if (this.productList.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //从仓库取商品
        Product product = this.productList.remove(0);
        this.notifyAll();

        return product;
    }

}
