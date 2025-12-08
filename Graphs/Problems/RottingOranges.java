class RottingOranges { // BFS
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh += 1;
                }
            }
        }

        int totalTime = 0;

        while(!q.isEmpty()){
            
            for(int qSize = q.size(); qSize>0;  qSize--){
                int[] rotten = q.poll();
                int x = rotten[0];
                int y = rotten[1];
                if(x<m-1 && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    fresh -= 1;
                    q.add(new int[]{x+1, y});
                }
                if(x>0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    fresh -= 1;
                    q.add(new int[]{x-1, y});
                }
                if(y<n-1 && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    fresh -= 1;
                    q.add(new int[]{x, y+1});
                }
                if(y>0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    fresh -= 1;
                    q.add(new int[]{x, y-1});
                }
            }

            totalTime += 1;
        }

        if(fresh > 0){
            return -1;
        }

        if(totalTime == 0 && fresh == 0){
            return 0;
        }
        else{
            return totalTime-1;
        }
    }
}
