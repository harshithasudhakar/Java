class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int startingColor = image[sr][sc];

        if(startingColor == color){
            return image;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int[] coord = q.remove();
            int row = coord[0];
            int col = coord[1];
            image[row][col] = color;
            if(row-1>= 0 && image[row-1][col] == startingColor){
                q.add(new int[]{row-1,col});
                image[row-1][col] = color;
            }
            if(row+1<n && image[row+1][col] == startingColor){
                q.add(new int[]{row+1,col});
                image[row+1][col] = color;
            }
            if(col-1>=0 && image[row][col-1] == startingColor){
                q.add(new int[]{row,col-1});
                image[row][col-1] = color;
            }
            if(col+1<m && image[row][col+1] == startingColor){
                q.add(new int[]{row,col+1});
                image[row][col+1] = color;
            }
        }

        return image;
    }
}
