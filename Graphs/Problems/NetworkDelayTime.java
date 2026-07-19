class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length; //edges

        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        
        for(int i = 0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++){

            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(times[i][1]);
            innerList.add(times[i][2]);

            graph.get(times[i][0]).add(innerList);
        }

        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k,0});
        
        dijkstras(pq, graph, dist, n);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i<dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            else if(i != 0 && i != k){
                max = Math.max(max, dist[i]);
            }
        }

        return max;
    }

    static void dijkstras(PriorityQueue<int[]> pq, ArrayList<ArrayList<ArrayList<Integer>>> graph, int[] dist, int n){

        while(!pq.isEmpty()){
            int[] element = pq.poll();

            for(int neighbors = 0; neighbors<graph.get(element[0]).size(); neighbors++){
                ArrayList<Integer> neighbor = graph.get(element[0]).get(neighbors);

                int dest = neighbor.get(0);
                int time = neighbor.get(1);

                if(dist[element[0]] + time < dist[dest]){
                    dist[dest] = dist[element[0]]+time;
                    pq.add(new int[]{dest, dist[dest]});
                }
            }
        }
    }
}
