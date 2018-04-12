package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   倒计时计数器
 * */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch cd = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务一正在执行。。。");
                    Thread.sleep((long)Math.random()*10000);
                    System.out.println("任务一执行完毕。。。");
                    cd.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务二正在执行。。。");
                    Thread.sleep((long)Math.random()*10000);
                    System.out.println("任务二执行完毕。。。");
                    cd.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            cd.await();
            System.out.println("所有任务执行完成。。。");
            System.out.println("正在执行主线程的任务"+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
