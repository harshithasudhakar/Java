import java.util.*;

class BFSnDFSInGraphs{

    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void initializeGraph(ArrayList<ArrayList<Integer>> graph, int v, int e){
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    static void createAdjList(ArrayList<ArrayList<Integer>> graph, Edge e){
        if((0<=e.src) && (e.src<graph.size())){
            graph.get(e.src).add(e.dest);
            System.out.println("src : " + e.src + " dest: " +e.dest);
        }
        else{
            System.out.println("Node out of graph bounds, enter a valid source.");
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
    
        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");
    
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current) {
        if (visited[current]) {
            return;
        }
        visited[current] = true;
        System.out.print(current + " ");
    
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int v = input.nextInt();
        System.out.println("Enter the no.of edges: ");
        int e =  input.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        initializeGraph(graph, v, e);

        for(int i = 0; i<e; i++){
            System.out.println("Enter the edge (src, dest): ");
            createAdjList(graph, new Edge(input.nextInt(), input.nextInt()));
        }

        boolean[] visited = new boolean[v];
        System.out.println("Enter a start node for BFS/DFS: ");
        int startNode = input.nextInt();

        System.out.println("BFS Traversal:");
        bfs(graph, visited, startNode);

        // Reset visited array for DFS
        Arrays.fill(visited, false);

        System.out.println("DFS Traversal:");
        dfs(graph, visited, startNode);
    }
}
