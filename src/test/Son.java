package test;

public class Son extends Parent{
    public Son(){
        System.out.println("Son...");
    }
    {
        System.out.println("Son 方法块");
    }
    static {
        System.out.println("static Son");
    }
    public static void main(String[] args) {
        Son son = new Son();
        A.hi();
    }
}
