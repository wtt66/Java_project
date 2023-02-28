package algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] array ={62,1,5,8,25,29,31,21,36,42,11,15,51,69};
        selection(array);
    }

    public static void selection(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            int s = i;//记录最小元素索引
            for (int j = i+1; j < a.length; j++) {
                    if(a[s]>a[j]){
                        s = j;
                    }
            }
            if (s!=i){
                swap(a,s,i);
            }
            System.out.println("选择排序结果为："+ Arrays.toString(a));
        }
    }

    public  static void swap(int[] a,int i, int j){
        if(a[i]<a[j]){
            int k = a[i];
            a[i]=a[j];
            a[j]=k;
        }
    }
}
