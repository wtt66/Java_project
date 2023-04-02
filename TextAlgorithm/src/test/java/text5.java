import java.util.Scanner;

public class text5 {
    public static void main(String[] args) {
        double n = 0;int m = 0;double sum = 0;//n为数列第一项，m为数列前n项和
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            sum = 0;
            for (int k = 0; k < m; k++) {

                sum = sum+n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f",sum);
            System.out.println();
        }


    }
}
