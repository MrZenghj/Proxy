package test;

public class OverRide {
    public void add(int i,double j){
        System.out.println(i+j);
    }

    public void add(double i,int j){
        this.add(i,j); //无线循环调用中
    }
}
