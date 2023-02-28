package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array ={1,5,8,25,29,31,21,62,36,42,11,15,51,69};
        //bubbleSort(array);
        bubbleSort_2(array);

    }

    public static void bubbleSort_2(int[] a){
        int n = a.length-1;
        while(true){
            int last = 0;//记录最后一次交换索引的位置
            for (int i = 0; i < n; i++) {
                if(a[i]>a[i+1]){
                    swap(a,i,i+1);
                }
                last = i;
            }
            n = last;
            System.out.println("第轮冒泡:"+Arrays.toString(a));
            if(n==0){
                break;
            }
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            //建立一个标志位，标记该次排序是否发生交换
            boolean swapped = false;
            for (int j = 0; j < a.length-1-i; j++) {
                System.out.println("比较次数"+j);
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                    swapped = true;
                }
            }
            System.out.println("第"+i+"轮冒泡结果为"+ Arrays.toString(a));
            if(!swapped){
                break;
            }
        }
    }

    public static void swap(int[] a,int i,int j){
        int k;
        k = a[i];
        a[i]=a[j];
        a[j]=k;
    }
}
