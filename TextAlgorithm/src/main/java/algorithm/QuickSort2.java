package algorithm;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] array ={62,1,5,8,25,29,31,21,36,42,11,15,51,69};
        quick(array,0,array.length-1);
    }


    public static void quick(int[] a, int l, int h){
        if(l>=h){
            return;
        }
        int p = partition(a, l, h);   //p 索引值
        quick(a,l,p-1);
        quick(a,p+1,h);
    }
    public static int partition(int[] a,int l,int h) {
        int pv=a[l] ,i = l;
        int j = h;
        while(i<j){
            while(i<j&&a[j]>pv){
                j--;
            }
            while(i<j&&a[i]<=pv){
                i++;
            }
            swap(a,i,j);
        }
        swap(a,l,j);
        System.out.println(Arrays.toString(a));
        return j;
    }

    public static void swap(int[] a, int i,int j){
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
    }
}
