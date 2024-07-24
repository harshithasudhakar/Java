// Adjacency List
// BFS Traversal

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graphs{
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void initializeGraph(ArrayList<Edge>[] graph, int v){
        for(int i = 0; i<v; i++){
            graph[i] = new ArrayList<>();
        }        
    }

    static void addEdges(ArrayList<Edge>[] graph, int src, int dest){
        ArrayList<Edge> edges = graph[src]; // not creating a new ArrayList.
        //get(src): returns the element at src(position).
        
        //Example: we wanna access the edges of vertex 2.
        //the arraylist at position 2 would be retrieved.
        //which has the edges [(2,0),(2,3)] (for example)
        //so in this case it would be like: edges = [(2,0), (2,3)]
        //edges is just a reference variable that points to an existing A.L obj in the memory
        //it doesn't reallocate the memory for the AL object.
        //but memory is allocated only for reference

        //Just creating a reference to the ArrayList returned by get().
        for (Edge e : edges) {
            if (e.dest == dest) {
                System.out.println("Edge from " + src + " to " + dest + " already exists.");
                return; // Exit the method without adding the edge
            }
        }
        edges.add(new Edge(src, dest)); // Add the edge if it doesn't already exist
    }

    static void deleteEdge(ArrayList<Edge>[] graph, int src, int dest){
        ArrayList<Edge> edges = graph[src];
        for(int i = 0; i < edges.size(); i++){
            if(edges.get(i).dest == dest){
                edges.remove(i);
                break;
            }
        }
    }

    static void getEdge(ArrayList<Edge>[] graph, int v) {
        for (Edge e : graph[v]) {
            System.out.println("Edge from " + e.src + " to " + e.dest);
        }
    }
    static void getAllEdges(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++){
            ArrayList<Edge> edges = graph[i]; // Retrieve the inner ArrayList of edges
            for (Edge e : edges) { // Iterate over the edges
                System.out.println("(" + e.src + ", " + e.dest + ")");
            }
        }
    }

    static void bfs(ArrayList<Edge>[] graph, int src){ // Time Complexity: 0(V+E)
        if (graph == null) return;
        
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[graph.length];

        queue.add(src);

        while(!queue.isEmpty()){
            int curr = queue.remove();
            System.err.println(curr);
            if(!visited[curr]){
                visited[curr] = true;
                for(int i = 0; i<graph[curr].size(); i++){
                    queue.add(graph[curr].get(i).dest);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = input.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[v];
        initializeGraph(graph,v);
        
        System.out.println("How many edges do you want to add?");
        int num = input.nextInt();
        for(int i = 0; i<num; i++){
            System.out.println("Source: ");
            int s = input.nextInt();
            System.out.println("Destination: ");
            int d = input.nextInt();
            addEdges(graph, s, d); //Creates a directed graph
        }

        System.out.println("All the edges of the graph are: ");
        getAllEdges(graph);

        System.out.println("Enter source of edge to delete:");
        int s = input.nextInt();

        System.out.println("Enter destination of edge to delete:");
        int d = input.nextInt();
        
        if (s >= 0 && s < v && d >= 0 && d < v) {
            deleteEdge(graph, s, d);
        } else {
            System.out.println("Invalid source or destination. Please enter values between 0 and " + (v-1));
        }
        System.out.println("The final graph is: ");
        getAllEdges(graph);

        System.out.println("BFS Traversal: ");
        bfs(graph, 0);
        input.close();
    }
}
