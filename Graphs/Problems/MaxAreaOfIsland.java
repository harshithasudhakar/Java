class MaxAreaOfIsland {
    static int n;
    static int m;
    public int maxArea(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        int maxArea = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    int count = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }

        return maxArea;
    }

    static int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>n-1 || j>m-1 || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return dfs(grid, i-1, j)+dfs(grid, i+1, j)+dfs(grid, i, j-1)+dfs(grid, i, j+1)+1;
    }
}
