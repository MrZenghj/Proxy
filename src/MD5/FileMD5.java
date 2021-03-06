package MD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class FileMD5 {
    /**
     *  将输入流进行加密等
     *      将输入的文件 进行MD5加密 获取文件特征值
     */
    public static String getMD5ValueOfFile(String fileName){
        //创建文件对象
        File file = new File(fileName);
        //判断文件是否存在,且是一个文件
        if(!(file.exists()&&file.isFile())){
            System.out.println("File is not correct!");
            return "error";
        }
        //定义一个文件输入流对象
        FileInputStream inputStream = null;
        //定义一个信息摘要对象
        MessageDigest digest = null;
        try {
            //实例化文件输入流
            inputStream = new FileInputStream(file);
            //实例化信息摘要,采用MD5算法
            digest = MessageDigest.getInstance("MD5");
            //定义一个字节数组
            byte[] buffer = new byte[1024];
            //定义一个length变量
            int length = -1;
            while((length = inputStream.read(buffer,0,buffer.length)) != -1){
                digest.update(buffer, 0, length);//更新摘要
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }finally{//释放资源
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //生成MD5值
        BigInteger bigInteger = new BigInteger(1, digest.digest());//1表示得到的结果为正数
        String md5 = bigInteger.toString(16);//16表示把数值转换为16进制
        return md5;
    }
}
