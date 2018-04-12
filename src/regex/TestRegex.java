package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    //正确匹配
    public static void main(String[] args) {
        //匹配拦截一定的号码
        String regex = "138\\d{8}";
        String number = "13876520080";
        boolean b = Pattern.matches(regex,number); //用于验证
        if(b){
            System.out.println("号码正确");
        }else{
            System.out.println("号码不正确");
        }

        //抓取
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(number);
        if(matcher.find()){
            //用于从一系列字符串中抓取数据（对应的数据）
            System.out.println(matcher.group());
        }
    }
}
