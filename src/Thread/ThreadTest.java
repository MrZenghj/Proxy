package Thread;

public class ThreadTest {
    private int j = 0;

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        Dec dec = tt.new Dec();
        Inc inc = tt.new Inc();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(dec);
            t.start();
            t  = new Thread(inc);
            t.start();
        }

    }

    private synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec " + j);
    }

    private synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName() + "+inc " + j);
    }

    class Dec implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

    class Inc implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }
}
