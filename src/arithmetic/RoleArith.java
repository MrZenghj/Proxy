package arithmetic;

import java.util.ArrayList;
import java.util.List;

public class RoleArith {
    /**
     *    已知道一个数的总和，从一串数组找出那几个数字相加和是等于这个数的总和
     *      例如：总和是544 数字有【1,2,4,8,16,32,64,128,256,512】
     *       总和为544 则为 32+512
     *    项目应用，用于权限表中，一个用户的权限为权限表的id相加，从中查找出该用户对应的权限
     *     设置最大权限id 为8129
     *
     *     分析：权限不可重复，由于是2的幂次方，前面的数相加不可能比后一个数大
     *            故总数值必然为前一个比它小的数加前面的数
     * */
    public static int[] arrays = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192};
    public static List<Integer> indexs = new ArrayList<>();
    public static int getMaxNumber(int input,int index) throws Exception {
        if(input >= arrays[index]){ //输入值数大于或等于数组某个数
            int result = input - arrays[index];
            indexs.add(index);
            if(result == 0){
                return 0; //当等于0，所有权限id已经找出
            }
            index--;
            return getMaxNumber(result,index);
        }
        index--;
        return getMaxNumber(input,index);
    }

    public static void main(String[] args) throws Exception {
        getMaxNumber(124,13);
        System.out.println(indexs);
    }

}
