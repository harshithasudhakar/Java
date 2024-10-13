import java.util.*;

class MaxSumOfHourGlass{ //2D Array

    static int findMaxSum(int[][] arr, int row, int col){
        
        int maxSum = Integer.MIN_VALUE;

        if(row<3 || col<3){

            System.out.println("Max Sum cannot be found as the size of the array is less than 3");
            return Integer.MIN_VALUE;
        }

        for(int i = 0; i<row-2; i++){
            for(int j = 0; j<col-2; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j]
                + arr[i+2][j+1] + arr[i+2][j+2];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of rows: ");
        int row = input.nextInt();
        System.out.println("Enter the no.of cols: ");
        int col = input.nextInt();
        int[][] arr = new int[row][col];

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                System.out.println("Enter the element at position: [" + i + "][" + j + "]");
                arr[i][j] = input.nextInt();
            }
        }
        
        int result = findMaxSum(arr, row, col);
        if (result != Integer.MIN_VALUE) {
            System.out.println("The maximum hourglass sum is: " + result);
        }
        
        input.close();
    }
}