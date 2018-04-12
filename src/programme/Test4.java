package programme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Test4 {
    /**
     * 从类似如下的文本文件中读取出所有的姓名，
     * 并打印出重复的姓名和重复的次数，
     * 并按重复次数排序：
     * 1,张三,28
     * 2,李四,35
     * 3,张三,28
     * 4,王五,35
     * 5,张三,28
     * 6,李四,35
     * 7,赵六,28
     * 8,田七,35
     */
   public static void main(String[] args) throws IOException {
       //文件地址
       InputStream is = Test4.class.getResourceAsStream("Test.txt");
       Map<String,Integer> results = new HashMap<String,Integer>();
       BufferedReader br = new BufferedReader(new InputStreamReader(is));
       String line = null;
       while((line = br.readLine()) != null){
           //计算重复的姓名
            readLine(line,results);
       }
       sortResults(results);
   }
    /**
     *      对TreeSet按照一定比较器进行比较
     * */
    private static void sortResults(Map<String, Integer> results) {
        TreeSet sortedResults = new TreeSet(
                new Comparator(){
                    public int compare(Object o1, Object o2) {
                    // TODO Auto-generated method stub
                        User user1 = (User)o1;
                        User user2 = (User)o2;
    /*如果compareTo返回结果0，则认为两个对象相等，新的对象不会增加到集合中去
     * 所以，不能直接用下面的代码，否则，那些个数相同的其他姓名就打印不出来。
     * */
    //return user1.value-user2.value;
    //return user1.value<user2.value?-1:user1.value==user2.value?0:1;

                        if(user1.value<user2.value)
                        {
                            return -1;
                        }else if(user1.value>user2.value)
                        {
                            return 1;
                        }else
                        {
                            return user1.name.compareTo(user2.name);
                        }
                    }
                }
        );

        Iterator iterator = results.keySet().iterator();

        while(iterator.hasNext()) {
            String name = (String)iterator.next();
            Integer value = (Integer)results.get(name);
            if(value > 1) {
                sortedResults.add(new User(name,value));
            }
        }
        printResults(sortedResults);
    }
    /**
     *  打印TreeSet
     * */
    private static void printResults(TreeSet sortedResults)
    {
        Iterator iterator  = sortedResults.iterator();
        while(iterator.hasNext()) {
            User user = (User)iterator.next();
            System.out.println(user.name + ":" + user.value);
        }
    }


    /**
     *   解析读取文件内容 存储到map集合中
     */
    private static void readLine(String line, Map<String, Integer> map) {
        if(!"".equals(line.trim())){
            String[] results = line.split(",");
            if(results.length == 3){
                String name = results[1];
                Integer value = map.get(name);
                if(value== null){
                    value = 0;
                }
                map.put(name,value+1); //同名加一
            }
        }
   }

    static class User
    {

        public  String name;

        public Integer value;

        public User(String name,Integer value)

        {
            this.name = name;

            this.value = value;

        }

        @Override
        public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        //下面的代码没有执行，说明往treeset中增加数据时，不会使用到equals方法。
            boolean result = super.equals(obj);
            System.out.println(result);
            return result;
        }
    }
}
