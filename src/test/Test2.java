package test;

public class Test2 {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        sb.append("a");
        sb2.append("b");
        swap(sb,sb2);
        System.out.println(sb.toString() + "," + sb2.toString());

        String a = "a";
        String b = "b";
        swap2(a,b);
        System.out.println(a + " " + b);
    }

    /**
     * 交换数据，地址引用只限于当前方法中 append 操作与地址空间数据
     * @param sb
     * @param sb2
     */
    public static void swap(StringBuffer sb,StringBuffer sb2){
        sb.append(sb2);
        sb2 = sb;
        System.out.println(sb2);
    }

    /**
     *  String类型交换后，并不影响传入的值
     * @param a
     * @param b
     */
    public static void swap2(String a,String b){
        String temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b);
    }

}
