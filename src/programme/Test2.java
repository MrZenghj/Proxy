package programme;

import java.io.*;

public class Test2 {
    /**
     * 编写一个程序，将d:\java目录下的所有.java文件
     *      复制到d:\jad目录下，并将原来文件的扩展名从.java改为.jad。
     *
     *      1.得到目录下的所有.java文件
     *      2.复制文件
     *      3.改名
     * */



    //1.得到目录下的所有.java文件
    public File[] getListFile(String filename){
        File file = new File(filename);
        //传入过滤器
        File[] files = file.listFiles(new MyFileFilter());
        return  files;
    }
    //2.复制文件 3.改名
    public void copyFile(String toFileName,File[] files) throws Exception {
        File destDir = new File(toFileName);
        if(!destDir.exists()){
            destDir.mkdir(); //不存在就创建
        }
        for (File file: files) {
            String destFileName = file.getName().replace(".java",".jad");
            FileInputStream fs = new FileInputStream(file);
            FileOutputStream fo = new FileOutputStream(new File(destDir,destFileName));
            //2.复制文件
            copy(fs,fo);
            fs.close();
            fo.close();
        }
    }

    public void copy(FileInputStream fs,FileOutputStream fo) throws IOException {
        int len = 0;
        byte[] buff = new byte[1024];
        while((len = fs.read(buff))!= -1 ){
            fo.write(buff);
        };
    }
}
/**
 *  文件过滤器 只返回以.java 开头的文件
 * */
class MyFileFilter implements FileFilter{
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
