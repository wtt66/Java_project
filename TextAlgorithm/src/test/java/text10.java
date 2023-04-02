import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
* 本题目的输入数据格式给的不好，不太好处理，
* 如果给的直接是一串数字，第一行一个数字表示任务数，第二行一串数字表示各个任务时间，
* 第三行一个数字表示几个线程此时输入数据就会非常好处理
* 解题思路：
* 1.只需根据第一行任务数，创建对应大小的数组count，进行循环写入，对所得数组count进行sort函数排序处理
* 2.再创建对应线程数的数组，将sort函数排序处理过后的数组count进行一个数组轮转，将count中的数轮次填入各个线程数组
* 3.此时各个线程数组内数据都是依次减小的所得
* */
public class text10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        int i = 0;
        while (sc.hasNextInt()){
            arr[i]=sc.nextInt();
            i++;

        }
    }
}
