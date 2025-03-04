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
        if((0 <= e.src) && (e.src <= graph.size())){
            graph.get(e.src).add(e.dest);
            System.out.println("src : " + e.src + " dest: " +e.dest);
        }
        else{
            System.out.println("Node out of graph bounds, enter a valid source.");
        }
    }

    static void addEdgeUsingAdjacencyMatrix(int[][] adjMatrix, Edge e){
        if(((0 <= e.src) && (e.src < adjMatrix.length))&& ((0 <= e.dest) && (e.dest < adjMatrix.length))){
            adjMatrix[e.src][e.dest] = 1;
            adjMatrix[e.dest][e.src] = 1; //Undirected graph
        }
        else{
            System.out.println("Node out of graph bounds, enter a valid source.");
            return;
        }
        for(int i =0; i<adjMatrix.length; i++){
            for(int j = 0; j<adjMatrix.length; j++){
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no.of vertices: ");
        int v = input.nextInt();
        System.out.println("Enter the no.of edges: ");
        int e =  input.nextInt();

        //ArrayList<ArrayList> graph = new ArrayList<ArrayList>();

        //initializeGraph(graph, v);

        int[][] adjMatrix = new int[v][v];

        for(int i = 0; i<e; i++){
            System.out.println("Enter the edge (src, dest): ");
            //addEdge(graph, new Edge(input.nextInt(), input.nextInt()));
            addEdgeUsingAdjacencyMatrix(adjMatrix, new Edge(input.nextInt(), input.nextInt()));
        }

    }
}
