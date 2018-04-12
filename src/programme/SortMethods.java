package programme;
/**
 *      关于一些排序算法
 *
 * */
public class SortMethods {
    public static void main(String[] args) {
        int[] arr = {12,34,3,1,54,23,2};
        //bubbleSort(arr);
        chooseSort(arr);
       for (int i =0;i< arr.length;i++){
           System.out.print(arr[i]+" ");
       }
    }
    /**
     *  冒泡排序法
     **/
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp ;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    /**
     *  选择排序法
     **/
    public static void chooseSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp ;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     *  快速排序-->切分方式
     */
    public static int partition(int []array,int lo,int hi){
        //三数取中
        int mid=lo+(hi-lo)/2;
        if(array[mid]>array[hi]){
            swap(array[mid],array[hi]);
        }
        if(array[lo]>array[hi]){
            swap(array[lo],array[hi]);
        }
        if(array[mid]>array[lo]){
            swap(array[mid],array[lo]);
        }
        int key=array[lo];

        while(lo<hi){
            while(array[hi]>=key&&hi>lo){   // 从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){   // 从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    //递归排序
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }

    //交换
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
}
