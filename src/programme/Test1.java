package programme;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Test1 {
    /**
     * 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中.
     *  a.txt文件中的单词用回车符分隔，b.txt文件中用回车或空格进行分隔。
     *
     * */
    public static void main(String[] args) throws Exception {
        FileManager a = new FileManager("a.txt",new char[]{'\n'});
        FileManager b = new FileManager("ab.txt",new char[]{'\n',' '});
        FileWriter c = new FileWriter("c.txt");
        String aWord = null;
        String bWord = null;
        while((aWord = a.nextWord()) != null){
            c.write(aWord + "\n");
            bWord = b.nextWord();
            if(bWord != null ){
                c.write(bWord + "\n");
            }
        }
        while((bWord = b.nextWord()) != null){
            c.write(bWord + "\n");

        }
        c.close();
    }
}
class FileManager{
   private String[] words = null; //用于存储单词
   private int pos = 0; //指针// publi
    //初始化数据
    /**
    *   @param filename 文件名字 地址
     *  @param  separator 分词符号
    */
   public FileManager(String filename,char[] separator) throws Exception {
       File file = new File(filename);
       FileReader reader = new FileReader(file);
       char[] buff = new char[(int)file.length()];
       int len = reader.read(buff);
       String result = new String(buff,0,len);
       String regex =  null;
       if(separator.length>0){
           regex = "" + separator[0] + "|" + separator[1];
       }else{
           regex = "" + separator[0];
       }
       words = result.split(regex);
       reader.close();
   }

   /**
    *  @return  String 返回单词
    */
   public String nextWord(){
        if(pos == words.length){
            return  null;
        }
        return words[pos++];
    }
}