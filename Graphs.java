//Creating and storing a graph

import java.util.ArrayList;
import java.util.Scanner;

class Graphs{
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void initializeGraph(ArrayList<ArrayList<Edge>> graph, int v){
        for(int i = 0; i<v; i++){
           graph.add(i, new ArrayList<Edge>());
        }        
    }

    static void addEdges(ArrayList<ArrayList<Edge>> graph, int src, int dest){
        ArrayList<Edge> edges = graph.get(src);
        for (Edge e : edges) {
            if (e.dest == dest) {
                System.out.println("Edge from " + src + " to " + dest + " already exists.");
                return; // Exit the method without adding the edge
            }
        }
        edges.add(new Edge(src, dest)); // Add the edge if it doesn't already exist
    }

    static void deleteEdge(ArrayList<ArrayList<Edge>> graph, int src, int dest){
        for(int i = 0; i<graph.size(); i++){
            graph.get(src).remove(src);
            System.out.println("Edge "+"("+ src +","+dest+ ")" + "deleted.");
        }
    }

    static void getEdge(ArrayList<ArrayList<Edge>> graph, int v) {
        for (Edge e : graph.get(v)) {
            System.out.println("Edge from " + e.src + " to " + e.dest);
        }
    }
    static void getAllEdges(ArrayList<ArrayList<Edge>> graph){
        for(int i = 0; i<graph.size(); i++){
            ArrayList<Edge> edges = graph.get(i); // Retrieve the inner ArrayList of edges
            for (Edge e : edges) { // Iterate over the edges
                System.out.println("(" + e.src + ", " + e.dest + ")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = input.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(v);

        initializeGraph(graph,v);
        
        System.out.println("How many edges do you want to add?");
        int num = input.nextInt();
        for(int i = 0; i<num; i++){
            System.out.println("Source: ");
            int s = input.nextInt();
            System.out.println("Destination: ");
            int d = input.nextInt();
            addEdges(graph, s, d);
        }

        System.out.println("All the edges of the graph are: ");
        getAllEdges(graph);

        input.close();
    }
}
