import java.util.*;

class ActivitySelection{

    static ArrayList<Integer> seq = new ArrayList<>();

    static void activity(int[] start, int[] end){
        int j = 0;
        int i = 1;
        
        seq.add(j);
        while(i<start.length){
            if(start[i]>=end[j]){
                seq.add(i);
                j = i;
            }
            i++;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i<n; i++){
            System.out.println("Enter start["+i+"]: " );
            start[i] = input.nextInt();
            System.out.println("Enter end["+i+"]: " );
            end[i] = input.nextInt();
        }
        activity(start, end);
        for(int ele: seq){
            System.out.println(ele);
        }
    }
}