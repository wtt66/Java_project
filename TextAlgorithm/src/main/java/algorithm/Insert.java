package algorithm;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] array ={62,1,5,8,25,29,31,21,36,42,11,15,51,69};
        insert(array);

    }

    public static void insert(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];//保存当前要插入的元素
            int j = i-1;
            while(j>=0){
                if(temp<a[j]){
                    a[j+1] = a[j];
                }else{
                    break;
                }
                j--;
            }
            a[j+1] = temp;
            System.out.println("第"+i+"次的排序结果为："+ Arrays.toString(a));
        }
    }
}
