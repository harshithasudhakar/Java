class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] canReachPacific = new boolean[n][m];
        boolean[][] canReachAtlantic = new boolean[n][m];

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == 0){
                    dfs(i, j, m, n, canReachPacific, heights);
                }
                if(j == 0){
                    dfs(i, j, m, n, canReachPacific, heights);
                }
                if(i == n-1){
                    dfs(i, j, m, n, canReachAtlantic, heights);
                }
                if(j == m-1){
                    dfs(i, j, m, n, canReachAtlantic, heights);
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(canReachPacific[i][j] == true && canReachAtlantic[i][j] == true){
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    result.add(coordinates);
                }
            }
        }

        return result;

    }

    static void dfs(int i, int j, int m, int n, boolean[][] visited, int[][] heights){
        if(i<0 || j<0 || i>=n || j>=m){
            return;
        }

        if(visited[i][j] == true){
            return;
        }

        visited[i][j] = true;

        // up
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            dfs(i - 1, j, m, n, visited, heights);
        }
        // down
        if (i + 1 < n && heights[i + 1][j] >= heights[i][j]) {
            dfs(i + 1, j, m, n, visited, heights);
        }
        // left
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(i, j - 1, m, n, visited, heights);
        }
        // right
        if (j + 1 < m && heights[i][j + 1] >= heights[i][j]) {
            dfs(i, j + 1, m, n, visited, heights);
        }
    }
}
