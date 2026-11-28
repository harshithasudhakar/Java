class DijkstrasAlgorithm {
    public int[] dijkstra(int V, int[][] edges, int src) {
        int E = edges.length;
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<E; i++){
           
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{src, 0});
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        
        dijkstras(graph, pq, dist);
        
        return dist;
        
    }
    
    static void dijkstras(List<List<int[]>> graph, PriorityQueue<int[]> pq, int[] dist){
        while(!pq.isEmpty()){
            int[] element = pq.poll();
            
            int u = element[0];
            int w = element[1];
            
            if(w > dist[u]) continue;

            for(int neighbors = 0; neighbors<graph.get(u).size(); neighbors++){
                int[] neighbor = graph.get(u).get(neighbors);
                int node = neighbor[0];
                int weight = neighbor[1];
                
                if(dist[u] + weight < dist[node]){
                    dist[node] = dist[u] + weight;
                    pq.add(new int[]{node, dist[node]});
                }
            }
        }
    }
}
