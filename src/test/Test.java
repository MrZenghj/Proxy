package test;

public class Test extends Thread{
    public static void main(String[] args) {
        Test test = new Test();
        test.run();
        test.start();
    }
    public void start(){
        System.out.println("hello");
    }


}
