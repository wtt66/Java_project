package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array ={1,5,8,11,15,21,25,29,31,36,42,51,62,69};
        int target = 51;
        int idx = binarySearch(array, target);
        System.out.println(idx);
    }

    //二分查找，找到返回元素索引，找不到返回-1
    public static int binarySearch(int[] a,int t){
        int l=0,r=a.length-1,mid;
        while(l<=r){
            //mid = (r+l)/2;   可能存在整数溢出问题
            //mid = (r+l)>>>1;  解决整数溢出问题
            mid = r-(r-l)/2;  //解决整数溢出问题
            if(a[mid]==t){
                return mid;
            } else if (a[mid]>t) {
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
