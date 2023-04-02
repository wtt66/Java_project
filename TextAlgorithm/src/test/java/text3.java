import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class text3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();//n表示数组长度
        int k = sc.nextInt();//k表示子序列数量


        double sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum =sum + (double)arr[i];
            System.out.println(sum);
        }
        System.out.println(sum);

        System.out.println(((double) sum/k));

    }
}
