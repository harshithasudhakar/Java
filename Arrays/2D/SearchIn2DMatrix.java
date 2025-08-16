class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int h = (m*n)-1;

        while(l<=h){
            int mid = l+(h-l)/2;
            int row = mid/n;
            int col = mid%n;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return false;
    }
}
