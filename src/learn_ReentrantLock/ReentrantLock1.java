package learn_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/3/8.
 */
public class ReentrantLock1 {
    private Lock lock = new ReentrantLock();

    public void m1() {
        try {
            lock.lock();//synchronized(this)类似，锁定的是堆的对象
            for (int i = 0; i < 10; i++)
                System.out.println("m1-" + i);
        } catch (Exception e) {
            System.out.println("m1启动");

        } finally {
            System.out.println("m1结束");
            lock.unlock();
        }
    }

    public void m2() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++)
                System.out.println("m2-" + i);

        } catch (Exception e) {
            System.out.println("m2启动");

        } finally {
            System.out.println("m2结束");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        new Thread(() -> reentrantLock1.m1()).start();
        new Thread(() -> reentrantLock1.m2()).start();
    }
}
