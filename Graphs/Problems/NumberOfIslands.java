class NumberOfIslands {
    int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>n-1 || j>m-1 || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }


}
