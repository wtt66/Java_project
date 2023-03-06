import java.util.Scanner;

public class text {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        //输入一个整数n，表示队列长度长度
        int n=sc.nextInt();
        //输入一个整数k,表示该队列的平滑值
        int k=sc.nextInt();
        System.out.print("1 "+(1+k)+" ");
        for (int i = 2;i<=n;i++){
            if(i!=1+k){
                System.out.print(i+" ");
            }

        }
    }
}
