package Thread.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wupeng
 * @date ：Created in 11:34 2019/1/15
 * @description：
 */
public class MyFairLock {
    /**
     * true 公平锁 false 非公平锁
     * fair ? new FairLock() : new NonFairLock();
     * */
    private  ReentrantLock lock = new ReentrantLock(true);

    public   void testFail(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +"获得了锁");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        MyFairLock fairLock = new MyFairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            fairLock.testFail();
        };
        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
    }
  }
