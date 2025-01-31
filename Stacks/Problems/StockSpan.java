import java.util.*;

class StockSpan{

    static void span(int n, int[] prices){

        int[] s = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!stk.isEmpty() && prices[stk.peek()]<=prices[i]){
                stk.pop();
            }
            s[i] = stk.isEmpty() ? i+1 : i-stk.peek();
            stk.push(i);
        }

        printSpans(n, s);

    }

    static void printSpans(int n, int[] s){
        for(int i = 0; i<n; i++){
            System.out.println(s[i]);
        }
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of days: ");
        int n = input.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i<n; i++){
            System.out.println("Enter the price: "); //arr[]={97,64,32,11,22,56}
            prices[i] = input.nextInt();
        }
        span(n, prices);
    }
}
