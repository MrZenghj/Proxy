package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    //指定延迟后 执行任务
    public static void quart(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(sf.format(System.currentTimeMillis()));
            }
        },2000);
    }

    //指定延迟后按一定的频率执行任务
    public static void quart2(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(sf.format(System.currentTimeMillis()));
            }
        },2000,1000);
    }

    public static void main(String[] args) {
        quart();
    }
}
