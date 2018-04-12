package HttpProxy;


import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpURL {

    public static void main(String[] args){
        HttpURL url =  new HttpURL();
        try{
            url.URLConnection();
        }catch(Exception e){
        }

    }
    public void URLConnection() throws IOException{
        URL url = new URL("https://www.baidu.com/?tn=93380420_hao_pg");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        InputStream input = urlConnection.getInputStream();
        byte[] bytes = IOUtils.readFully(input,-1,false);
        System.out.println(bytes);
    }
}
