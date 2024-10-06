// Adjacency List
// BFS Traversal
// DFS Traversal

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

    static void bfs(ArrayList<Edge>[] graph, int src){ // Time Complexity: O(V+E)
    
        if (graph == null || graph.length == 0) return; // Ensure graph is valid
    
        Queue<Integer> queue = new LinkedList<>(); // Initialize the queue
        boolean[] visited = new boolean[graph.length]; // Boolean array to track visited nodes
        
        queue.add(src); // Add the starting node to the queue
        visited[src] = true; // Mark the starting node as visited
    
        while(!queue.isEmpty()){ // Loop until the queue is empty
            int curr = queue.remove(); // Remove the front node in the queue
            System.out.print(curr + " "); // Print the current node
    
            // Iterate through all the adjacent nodes (edges) of the current node
            for(int i = 0; i < graph[curr].size(); i++){
                int neighbor = graph[curr].get(i).dest; // Get the destination vertex (neighbor)
                
                if (!visited[neighbor]) { // Only add unvisited neighbors to the queue
                    queue.add(neighbor); // Add the neighbor to the queue
                    visited[neighbor] = true; // Mark the neighbor as visited
                }
            }
        }
    }    

    static void dfs(ArrayList<Edge>[] graph, int v) { // Time Complexity: O(V+E)

        if (graph == null) return;
    
        Stack<Integer> stk = new Stack<>(); // To maintain depth-wise traversal
        boolean[] visited = new boolean[graph.length]; // To ensure that we don't revisit a node that has already been visited
    
        stk.push(v);
    
        while (!stk.isEmpty()) {
            v = stk.pop();
    
            // Check if the node has already been visited
            if (!visited[v]) {
                visited[v] = true; // Mark as visited
                System.out.print(v + " "); // Print the current node
    
                // Push neighbors onto the stack in reverse order
                for (int i = graph[v].size() - 1; i >= 0; i--) {
                    Edge e = graph[v].get(i);
                    if (!visited[e.dest]) { // Only push if not visited
                        stk.push(e.dest);
                    }
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
        
        System.out.println();
        System.out.println("DFS Traversal: ");
        dfs(graph, 0);
        
        input.close();
    }
}
