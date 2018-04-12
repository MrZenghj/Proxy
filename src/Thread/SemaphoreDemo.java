package Thread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *    信号量
 *      主要控制并发数量问题 限流
 */
public class SemaphoreDemo {

    class SemaphoreRunable implements Runnable{
        private Semaphore semaphore; //信号量
        private int number; //代表一个用户
        public SemaphoreRunable(Semaphore semaphore,int number){
            this.semaphore = semaphore;
            this.number = number;
        }

        @Override
        public void run() {
            try {
                //获取信量
                semaphore.acquire();
                System.out.println("用户" + number + "进入窗口");
                Thread.sleep((long)Math.random()*1000);
                System.out.println("用户" + number + "买票完成");
                Thread.sleep((long)Math.random()*1000);
                System.out.println("用户" + number + "离开。。。");
                //释放信号量
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void execute(){
        //设置信号量
       final Semaphore semaphore = new Semaphore(2);
        //使用线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //模拟用户
        for (int i = 0; i < 20; i++) {
            executorService.execute(new SemaphoreRunable(semaphore,i));
        }
        executorService.shutdown();
    }
    public static void main(String[] args) {
        SemaphoreDemo s = new SemaphoreDemo();
        s.execute();
    }

}
