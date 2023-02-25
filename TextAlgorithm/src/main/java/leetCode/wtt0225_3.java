package leetCode;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class wtt0225_3 {
    public static int lengthOfLongestSubstring(String s) {
        //维护当前最长不重复子串
        //String s = "adsuidahdq";
        Set<Character> set = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int maxlength = 0;
        while (right<s.length()){
            if (!set.contains(s.charAt(right))){
                //未查到重复字符串就一直加，right右移
                set.add(s.charAt(right));
                right++;
            }else {
                //倘若查到重复的字符则不动，left右移，set删除掉右移途中遇到的重复的元素
                set.remove(s.charAt(left));
                left++;
            }
            maxlength = Math.max(maxlength,set.size());
        }
        return maxlength ;
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
    }
}
