package learn_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/3/8.
 */
public class ReentrantLock2 {
    private Lock lock = new ReentrantLock();

    public void testMethod(){
        lock.lock();
        for(int i =0;i<5;i++){
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + (" " + (i + 1)));
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock2 r2 = new ReentrantLock2();
        new Thread(()->r2.testMethod()).start();
    }
}
