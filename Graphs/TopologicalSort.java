import java.util.*;

class TopologicalSort{

    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void initializeGraph(ArrayList<ArrayList<Integer>> graph, int v){
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int v, int edges, Edge e){
        if(0<= e.src && e.src<v){
            graph.get(e.src).add(e.dest);
        }
        else{
            System.out.println("Out of bounds.");
        }
    }

    static void topoSort(ArrayList<ArrayList<Integer>> graph, int v){
        boolean[] visited = new boolean[v];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i<v; i++){
            topoSortUtil(graph, visited, s, i);
        }

        while(!s.isEmpty()){
            System.out.println(s.pop()+ " ");
        }
    }

    static void topoSortUtil(ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> s, int i){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        for(int neighbor : graph.get(i)){
            if(!visited[neighbor]){
                topoSortUtil(graph, visited, s, neighbor);
            }
        }
        s.push(i);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int v = input.nextInt();
        System.out.println("Enter the no.of edges: ");
        int edges = input.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        initializeGraph(graph, v);

        for(int i = 0; i<edges; i++){
            System.out.println("Enter the edge (src, dest): ");
            addEdge(graph, v, edges, new Edge(input.nextInt(), input.nextInt()));
        }
        
        System.out.println("Topo Sorted: ");
        topoSort(graph, v);
    }
}
