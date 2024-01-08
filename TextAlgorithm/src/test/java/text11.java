import java.util.Scanner;

public class text11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        int i = 0;
        while(sc.hasNextInt()){
            arr[i]=sc.nextInt();
            i++;
        }
    }
}
