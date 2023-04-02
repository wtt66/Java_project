import java.util.Scanner;

public class text6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] nums = new int[m];
        int base = n/m;
        for (int i = 0; i < m; i++) {
            nums[i] = base;

        }
        int remain = n%m;
        for (int i = 0; i < remain; i++) {
            nums[i]++;
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            int x = nums[i];
            sum+=x*x;
        }

        if(sum==p){
            for (int i = 0; i < m; i++) {
                System.out.print(nums[i]+" ");
            }
        }else {
            System.out.println("-1");
        }
    }
}
