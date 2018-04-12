package programme;

import java.io.UnsupportedEncodingException;

public class Test3 {

    /**
     * 编写一个截取字符串的函数，输入为一个字符串和字节数，
     * 输出为按字节截取的字符串，但要保证汉字不被截取半个，
     * 如“我ABC”，4，应该截取“我AB”，
     * 输入“我ABC汉DEF”,6，应该输出“我ABC”，而不是“我ABC+汉的半个”。
     * */
    public static void main(String[] args) throws Exception {
        String str =  "我ABC";
        String str2 = "我ABC汉DEF";
        int num = trimGBK(str.getBytes("GBK"),4);
        int num2 = trimGBK(str2.getBytes("GBK"),6);
        System.out.println(str.substring(0,num));
        System.out.println(str2.substring(0,num2));
    }

    public static int trimGBK(byte[] bytes,int n){
        int num = 0;
        boolean chineseHalf = false;
        //中文的字节码byte 为负数
        for (int i = 0; i < n; i++) {
            if(bytes[i]<0 && !chineseHalf){
                chineseHalf  = true;
            }else{
                num ++ ;
                chineseHalf = false;
            }
        }
        return num;
    }
}
