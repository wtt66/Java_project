import java.util.Scanner;

public class text7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();//几把钥匙

            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }

            int count = 0;
            int count1 = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < j; k++) {
                    if(ar[k]<j&&ar[k]>count){
                        System.out.print(j+" ");
                        count1 = count +1;
                    }
                }
                count = count1;

            }

        }
    }
}
