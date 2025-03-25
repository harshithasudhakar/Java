import java.util.*;

class BellmanFordAlgorithm{ //Shortest distance from every node to all other vertices
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void initializeGraph(ArrayList<ArrayList<Edge>> graph, int V){
        for(int i = 0; i<V; i++){
            graph.add(new ArrayList<Edge>());
        }
    }

    static void createAdjList(ArrayList<ArrayList<Edge>> graph, Edge e){
        if((0<=e.src) && (e.src<graph.size())){
            graph.get(e.src).add(e);
            System.out.println("src : " + e.src + " dest: " +e.dest + " weight: "+e.wt);
        }
        else{
            System.out.println("Node out of graph bounds, enter a valid source.");
        }
    }

    static void shortestPath(ArrayList<ArrayList<Edge>> graph, int V, int src){
        int[] dist = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int k = 0; k<V-1; k++){
            for(int i = 0; i<V; i++){
                for(Edge neighbor : graph.get(i)){
                    int u = neighbor.src;
                    int v = neighbor.dest;
                    int w = neighbor.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        //Negative weight cycles
        for(int i = 0; i<V; i++){
            for(Edge neighbor : graph.get(i)){
                int u = neighbor.src;
                int v = neighbor.dest;
                int w = neighbor.wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    System.out.println("Negative weight cycle exists.");
                    break;
                }
            }
        }
    
        System.out.println("Distances: " + Arrays.toString(dist));
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int V = input.nextInt();
        System.out.println("Enter the no.of edges: ");
        int e =  input.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

        initializeGraph(graph, V);

        for(int i = 0; i<e; i++){
            System.out.println("Enter the edge (src, dest, weight/cost): ");
            createAdjList(graph, new Edge(input.nextInt(), input.nextInt(), input.nextInt()));
        }

        shortestPath(graph, V, 0);

    }
}
