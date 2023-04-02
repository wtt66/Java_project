import org.omg.CORBA.StringHolder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class text9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String ss = sc.next();
            int red = 0,yellow = 0,blue = 0,count = 0,tag = 0,len = ss.length();
            String arr[] = new String[len];
            for (int i = 0; i < len; i++) {
                if (ss.charAt(i)=='{'){
                    arr[i]="红";
                    red += 1;
                }else if (ss.charAt(i)=='[') {
                    arr[i]="黄";
                    yellow += 1;
                } else if (ss.charAt(i)=='(') {
                    arr[i]="蓝";
                    blue += 1;
                }else if (ss.charAt(i)=='}'){
                    arr[i]="红";
                    red -= 1;
                    if (red < 0){
                        tag = 0;
                    }
                }else if (ss.charAt(i)==']') {
                    arr[i]="黄";
                    yellow -= 1;
                    if (yellow < 0){
                        tag = 0;
                    }
                } else if (ss.charAt(i)==')') {
                    arr[i]="蓝";
                    blue -= 1;
                    if (blue < 0){
                        tag = 0;
                    }
                }
            }
            count = red + yellow +blue;
            if (count == 0&&tag==1){
                for (int i = 0; i < len; i++) {
                    System.out.print(arr[i]);
                }
            }else {
                System.out.println("输入错误");
            }
        }
    }
}
