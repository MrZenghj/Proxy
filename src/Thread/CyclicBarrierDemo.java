package Thread;

import java.util.concurrent.*;

/***
 *      障碍物
 *          让一组线程相互等待知道所有线程都完成各自的工作之后才执行后面的线程
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //指定五个人吃饭
        //构造方法传入执行操作之前需要做的事情 也可不传入
        final CyclicBarrier cb = new CyclicBarrier(5,new Runnable() {
            public void run() {
                System.out.println("人员到齐，各自先行拍照留念...");
                try {
                    Thread.sleep((long)(Math.random()*10000));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        //线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟5个人
        for(int i=0; i<5 ; i++) {
            int user = i+1;
            Runnable rb = new Runnable() {
                public void run() {
                    try {
                        //每个人到达时间不一样
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println(user +"到达聚餐点，当前已有"+(cb.getNumberWaiting()+1)+"个人到达...");
                        //执行等待
                        cb.await();
                        if(user == 1) {
                            System.out.println("拍照结束，人员到齐，开始吃饭...");
                        }
                        //一段时间后
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println(user + "离开，回家");
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            };
            threadPool.execute(rb);
        }
        threadPool.shutdown();
    }
}
