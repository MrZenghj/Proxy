package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListCollecttion {
    public static void main(String[] args) {
        String[] s = new String[]{"nihao","hello","i just"};
        float fs = 1;
        double d = 9;
        System.out.println(fs);
        System.out.println(d);
        int[] number = new int[]{1,3,4,5,7,8};
        List list = Arrays.asList(s);
        //list.add("sdad");  //不允许操作，因为返回的是固定大小的list数组视图 并不能做相关add remove
        List<int[]> list2 = Arrays.asList(number); //转换成为一个数组的形式
        ArrayList f = new ArrayList<>();
        //如果需要将基本数据类型的数组转换成封装数据类型
        for (int num : number) {
            f.add(num);
        }
        System.out.println(f);
        System.out.println(f.toArray());
        System.out.println(list);
        System.out.println(list2);

        /********************************************************/

        int[] a1 = new int[]{1,2,3};
        String[] a2 = new String[]{"a","b","c"};

        System.out.println(Arrays.asList(a1)); //会将整个数组当做一个对象进行存储
        System.out.println(Arrays.asList(a2));
    }
}