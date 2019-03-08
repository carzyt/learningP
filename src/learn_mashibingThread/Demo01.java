package learn_mashibingThread;

/**
 * Created by Administrator on 2019/3/8.
 */
public class Demo01 {
    private int count = 10;


    public void test(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

    public static void main(String[] args) {
        Demo01 demo01=new Demo01();
        new Thread(()->demo01.test()).start();
        new Thread(()->demo01.test()).start();
    }
}
