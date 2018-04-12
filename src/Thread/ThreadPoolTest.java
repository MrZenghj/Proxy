package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
       /*Long start = System.currentTimeMillis();
       final Random random = new Random();
       final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
           Thread thread = new Thread(){
               @Override
               public void run() {
                   list.add(random.nextInt());
               }
           };
           thread.start();
           thread.join(); // 等待其他线程执行完毕后才执行主线程
        }
        System.out.println("end 时间：" + (System.currentTimeMillis() - start));
        System.out.println(list.size());*/

        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = new ThreadPoolExecutor(1,1,
                0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("nihao");
            }
        });


    }
}
