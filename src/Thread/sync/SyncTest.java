package Thread.sync;
/**
 *      同步机制
 *      synchronized 是Java的关键字，是Java的内置特性，在JVM层面实现了对临界资源的同步互斥访问
 *      缺点：
 *          1、不能响应中断，线程需要等待
 *          2、同一时刻不论是读还是写同一时刻都只能有一个线程进行对资源的访问
 *          3、锁的释放由虚拟机来完成，不用人工干预，不过此即使缺点也是优点，
 *              优点是不用担心会造成死锁，缺点是由可能获取到锁的线程阻塞之后其他线程会一直等待，性能不高。
 * */
public class SyncTest {

    public void syncTest(){
        //同步代码块
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                System.out.println("线程名：" + Thread.currentThread().getName()+"，值为："+ i);
            }
        }
    }

    //同步方法 同上类似 不同的是作用域
    public synchronized void syncMethod(){
        for (int i = 0; i < 5; i++) {
            System.out.println("线程名：" + Thread.currentThread().getName()+"，值为："+ i);
        }
    }


    public static void main(String[] args) {
        SyncTest sync = new SyncTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //sync.syncTest();
                sync.syncMethod();
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //sync.syncTest();
                sync.syncMethod();
            }
        },"t2").start();
    }



}
