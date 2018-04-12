package Stream;

import java.io.*;

public class StreamTest {

    public static void main(String[] args) throws Exception {
       /* //字节流
        FileInputStream fs = new FileInputStream("F:\\idea-wordspace\\Proxy\\src\\Stream\\test.txt");
        byte[] buff = new byte[1024];
        int leng = fs.read(buff);
        String s = new String(buff,0,leng,"utf-8");
        System.out.println(s);
        fs.close();
        FileOutputStream fo = new FileOutputStream("F:\\idea-wordspace\\Proxy\\src\\Stream\\test.txt",true);
        fo.write("\r\n do you love me ,说你爱我到什么程度！！".getBytes("utf-8"));
        fo.close();*/

        //字符流
        FileReader reader = new FileReader("F:\\idea-wordspace\\Proxy\\src\\Stream\\test.txt");
        char[] buf = new char[1024];
        int len = reader.read(buf);
        System.out.println(new String (buf,0,len));
        reader.close();
        FileWriter writer  = new FileWriter("F:\\idea-wordspace\\Proxy\\src\\Stream\\test.txt");
        writer.write("蝴蝶眨了几次眼才学会飞行。");
        writer.close();
    }
}
