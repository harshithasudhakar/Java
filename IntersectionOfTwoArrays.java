import java.lang.*;
import java.util.Scanner;
class IntersectionOfTwoArrays{
    public static int[] intersection(int[] nums1, int[] nums2) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        if(nums1.length<=nums2.length){
            for(int i=0; i<nums1.length; i++){
                for(int j=i; j<nums1.length; j++){
                    if(nums1[j]==nums2[j]){
                        arr[j]= nums1[j];
                    }
                }
            }
            return arr;
        }
        else{
            for(int i=0; i<nums2.length; i++){
                for(int j=i; j<nums2.length; j++){
                    if(nums2[j]==nums1[j]){
                        arr[j]= nums2[j];
                    }
                }
            }
            return arr;
        }
        
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int[] nums1 = new int[n1];
        int n2 = input.nextInt();
        int[] nums2 = new int[n2];
        intersection(nums1, nums2);
    }
}