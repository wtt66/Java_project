import java.util.Scanner;

public class text2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入整数n
        int n = sc.nextInt();
        //输入整数p,最终希望n成为p的倍数
        int p = sc.nextInt();
        int[] nums = new int[10];
        int sum = 0; //计算各位数字之和
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        sc.close();
        int mod = n%p;
        if (mod==0){//已经是p的倍数
            System.out.println(0);
        }else{
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i <=sum ; i++) {
                int diff = check(n,p,nums,i,mod,0);
                if(diff >= 0&&diff<minDiff){
                    minDiff = diff;
                }
            }
            System.out.println(minDiff == Integer.MAX_VALUE?-1:minDiff);
        }

    }

    private static int check(int n,int p,int[] nums,int cnt,int mod,int cur){
        if(cnt == 0){
            return cur %p == 0 ? 0:Integer.MAX_VALUE;
        }
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if(nums[i]>0){
                nums[i]--;
                int newCur = cur +(i*(cnt == 0?-1:1));
                int newDiff = check(n,p,nums,cnt-1,mod,newCur);
                if (newDiff>=0&&newDiff<diff){
                    diff = newDiff;
                }
                nums[i]++;
            }

        }
        return diff ==Integer.MAX_VALUE?diff:Math.min(diff,Math.abs(mod-(cur%p)));
    }
}
