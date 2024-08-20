import java.util.Scanner;
class BinarySearch{

    void binarySearch(int ele, int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == ele){
                System.out.println("The element is at index: " + mid);
                return;
            }
            if(arr[mid] < ele){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println("Element not found in the array.");
    }
    public static void main(String[] args){
        BinarySearch bis = new BinarySearch();
        System.out.println("Enter size of array: ");
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        int[] arr = new int[l];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i<l; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Enter element to be searched: ");
        int ele = input.nextInt();
        bis.binarySearch(ele, arr);
    }
}
