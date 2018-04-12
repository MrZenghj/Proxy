package Thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  两个线程之间进行数据的交换
 * */
public class ExchangerDemo {
    public static void main(String[] args) {
        final Exchanger exchanger = new Exchanger();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String chage =(String)exchanger.exchange("甲方的合同");
                    System.out.println("甲方获取："+ chage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String chage =(String)exchanger.exchange("乙方的合同");
                    System.out.println("乙方获取："+ chage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}
