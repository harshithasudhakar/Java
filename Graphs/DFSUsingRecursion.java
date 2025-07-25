import java.util.*;

class DFSUsingRecursion{
    static class Edge{
        int src,dest;
        
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void makeGraph(ArrayList<ArrayList<Integer>> graph, int v){
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    static void fillGraph(ArrayList<ArrayList<Integer>> graph, int v, ArrayList<Edge> edgeList){
        for(int i=0; i<edgeList.size(); i++){
            int s = edgeList.get(i).src;
            int d = edgeList.get(i).dest;
            graph.get(s).add(d);
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, int src){
        if(visited[src]){
            return;
        }

        visited[src] = true;
        System.out.println(src);

        for(int neighbour: graph.get(src)){
            if(!visited[neighbour]){
                dfs(graph, visited, neighbour);
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int v = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = input.nextInt();

        ArrayList<Edge> edgeList = new ArrayList<Edge>();

        for(int i = 0; i<e; i++){
            edgeList.add(new Edge(input.nextInt(), input.nextInt()));
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        makeGraph(graph, v);
        fillGraph(graph, v, edgeList);

        boolean[] visited = new boolean[v];
        dfs(graph, v, visited, 0);

        input.close();
    }
}
