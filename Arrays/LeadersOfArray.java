import java.util.*;

class LeadersOfArray{

    static ArrayList<Integer> findLeaders(int[] arr){

        ArrayList<Integer> leader = new ArrayList<>();
        int maxElement = arr[arr.length-1];
        leader.add(maxElement);
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i] > maxElement){
                leader.add(arr[i]);
                maxElement = arr[i];
            }
        }
        return leader;
    }

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println(findLeaders(arr));
        input.close();
    }
}