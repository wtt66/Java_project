import java.util.Scanner;

public class text8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double i = sc.nextDouble();
            int in = sc.nextInt();
            double sum = i;
            for (int j = 1; j < in; j++) {
                i = Math.sqrt(i);
                sum = sum + i;
            }
            System.out.printf(String.format("%.2f",sum));
        }
    }
}
