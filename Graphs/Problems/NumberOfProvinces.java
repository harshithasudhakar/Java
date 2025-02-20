class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i<n; i++){
           if (!visited[i]){
                dfs(i, visited, isConnected);
                count++;  // Incrementing count after dfs
            }
        }
        return count;
    }

    static void dfs(int currentCity, boolean[] visited, int[][] isConnected){
        visited[currentCity] = true;

        for(int i = 0; i<isConnected.length; i++){
            if(isConnected[currentCity][i] == 1 && !visited[i]){
                dfs(i, visited, isConnected);
            }
        }
    }
}
