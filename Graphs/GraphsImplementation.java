import java.util.*;

class GraphsImplementation{

    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void initializeGraph(ArrayList<ArrayList> graph, int v){
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    static void addEdge(ArrayList<ArrayList> graph, Edge e){
        if(graph.get(e.src) != null){
            graph.get(e.src).add(e.dest);
            System.out.println("src : " + e.src + " dest: " +e.dest);
        }
        else{
            System.out.println("Node not in graph, enter a valid source.");
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int v = input.nextInt();
        System.out.println("Enter the no.of edges: ");
        int e =  input.nextInt();

        ArrayList<ArrayList> graph = new ArrayList<ArrayList>();

        initializeGraph(graph, v);

        for(int i = 0; i<e; i++){
            System.out.println("Enter the edge (src, dest): ");
            addEdge(graph, new Edge(input.nextInt(), input.nextInt()));
        }

    }
}
