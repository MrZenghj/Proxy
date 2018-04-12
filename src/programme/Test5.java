package programme;

public class Test5 {
    public static void main(String[] args) {

        //loop(1237);
       // System.out.println(loop2(3));
       System.out.println(loop3());
    }

    /**
     * 一个整数，大于0，不用循环和本地变量，按照n，2n，4n，8n的顺序递增
     * ，当值大于5000时，把值按照指定顺序输出来。
     */
    public static void loop(int num){
        System.out.println(num);
        if(num <= 5000){
            loop(num*2);
        }
        System.out.println(num);
    }

    /**
     * 第1个人10，第2个比第1个人大2岁，依次递推，请用递归方式计算出第8个人多大？
     */
    public static int loop2(int n){
        if(n == 1 ){
            return 10;
        }
        return loop2(n-1)+2;
    }

    /**
     * 猴子摘了N个桃子，第一次吃了一半又多2个，如此循环，等到第10 天后发现只剩下1个
     */
    public static int loop3(){
        int n = 1;
        for (int i = 0; i < 9; i++) {
         n = (n+1)*2;
        }
        return n;
    }


}
