//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class FrogJumpToKthStep {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        if(n <= 1){
            return 0;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = Math.abs(arr[0] - arr[1]); 
        for(int i = 2; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i-j >= 0){
                    int jump = dp[i-j] + Math.abs(arr[i-j] - arr[i]);
                    min = Math.min(min, jump);
                }
            }
            dp[i] = min;
        }
        
        return dp[n-1];
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
