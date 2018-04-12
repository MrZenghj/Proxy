package Thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *      lock 锁，基于接口方面设置的锁  类方面
 *          1、在finally中必须释放锁，不然容易造成线程死锁
 *          2、Lock有多个锁获取的方式，可尝试获得锁，线程可以不用一直等待
 *          3、可以判断
 */
public class LockTest {
    //  锁
    private Lock lock = new ReentrantLock();

    private void tryBlock(){
        try{
            System.out.println("线程名"+Thread.currentThread().getName() + "获得了锁");
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            lock.unlock(); // 释放锁
            System.out.println("线程名"+Thread.currentThread().getName() + "释放了锁");
        }
    }
    public void method() {
        lock.lock(); //锁
        tryBlock();
    }

    public void method2() {
        if(lock.tryLock()){
            tryBlock();
        }else {
            System.out.println("我是" +Thread.currentThread().getName() + "该所又有人获取，我就不用锁了");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // lockTest.method();
                lockTest.method2();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               // lockTest.method();
                lockTest.method2();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
