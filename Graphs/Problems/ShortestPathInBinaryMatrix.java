class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        int[][] visited = new int[grid.length][grid[0].length];
        visited[0][0] = 1;
        
        int result = bfs(q, grid, visited);

        return result;
    }

    static int bfs(Queue<int[]> q, int[][] grid, int[][] visited){
        while(!q.isEmpty()){
            int[] element = q.poll();
            int i = element[0];
            int j = element[1];
            int dist = element[2];

            if(i == grid.length-1 && j == grid[0].length-1){
                return dist;
            }

            // Check each neighbor's bounds, grid value, and visited status before adding
            if(i-1 >= 0 && grid[i-1][j] == 0 && visited[i-1][j] == 0){
                q.add(new int[]{i-1, j, dist+1});
                visited[i-1][j] = 1;
            }
            if(i-1 >= 0 && j+1 < grid[0].length && grid[i-1][j+1] == 0 && visited[i-1][j+1] == 0){
                q.add(new int[]{i-1, j+1, dist+1});
                visited[i-1][j+1] = 1;
            }
            if(i-1 >= 0 && j-1 >= 0 && grid[i-1][j-1] == 0 && visited[i-1][j-1] == 0){
                q.add(new int[]{i-1, j-1, dist+1});
                visited[i-1][j-1] = 1;
            }
            if(i+1 < grid.length && grid[i+1][j] == 0 && visited[i+1][j] == 0){
                q.add(new int[]{i+1, j, dist+1});
                visited[i+1][j] = 1;
            }  
            if(i+1 < grid.length && j-1 >= 0 && grid[i+1][j-1] == 0 && visited[i+1][j-1] == 0){
                q.add(new int[]{i+1, j-1, dist+1});
                visited[i+1][j-1] = 1;
            }
            if(i+1 < grid.length && j+1 < grid[0].length && grid[i+1][j+1] == 0 && visited[i+1][j+1] == 0){
                q.add(new int[]{i+1, j+1, dist+1});
                visited[i+1][j+1] = 1;
            }
            if(j-1 >= 0 && grid[i][j-1] == 0 && visited[i][j-1] == 0){
                q.add(new int[]{i, j-1, dist+1});
                visited[i][j-1] = 1;
            }
            if(j+1 < grid[0].length && grid[i][j+1] == 0 && visited[i][j+1] == 0){
                q.add(new int[]{i, j+1, dist+1});
                visited[i][j+1] = 1;
            }
        }

        return -1;
    }
}
