public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        int dim = points.length;
        int[][] dp = new int[dim][3];
        
        for(int i = 0;i<dim; i++){
            for(int j = 0; j<points[i].length; j++){
                if(i == 0){
                    dp[i][j] = points[i][j];
                    continue;
                }
                
                for(int k = 0; k<points[i].length; k++){
                    if(k == j){
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], points[i][j]+dp[i-1][k]);
                }
                
            }
        }
        return Math.max(dp[dim - 1][0], Math.max(dp[dim - 1][1], dp[dim - 1][2]));

    }
}
