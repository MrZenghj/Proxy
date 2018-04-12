package test;

public class Parent {
    public Parent(){
        System.out.println("Parent...");
    }
    {
        System.out.println("parent 方法块");
    }
    static {
        System.out.println("static parent");
    }
}
