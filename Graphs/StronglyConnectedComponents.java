import java.util.*;

class StronglyConnectedComponents { // Using Kosaraju's Algo

    static class Edge {
        int src, dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void initializeGraph(ArrayList<ArrayList<Integer>> graph, int v) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int v, Edge e) {
        if (0 <= e.src && e.src < v) {
            graph.get(e.src).add(e.dest);
        } else {
            System.out.println("Out of bounds.");
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> s, int i) {
        visited[i] = true;
        for (int neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, s, neighbor);
            }
        }
        s.push(i);
    }

    static void dfsPrint(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                dfsPrint(graph, visited, neighbor);
            }
        }
    }

    static void kosaraju(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> s = new Stack<>();

        // Step 1: Topological sort
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(graph, visited, s, i);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        initializeGraph(transpose, v);
        for (int i = 0; i < v; i++) {
            for (int neighbor : graph.get(i)) {
                transpose.get(neighbor).add(i);
            }
        }

        // Step 3: DFS on transposed graph
        Arrays.fill(visited, false);
        System.out.println("Strongly Connected Components:");
        while (!s.isEmpty()) {
            int node = s.pop();
            if (!visited[node]) {
                dfsPrint(transpose, visited, node);
                System.out.println(); // print one SCC per line
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = input.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = input.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        initializeGraph(graph, v);

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge (src dest): ");
            addEdge(graph, v, new Edge(input.nextInt(), input.nextInt()));
        }

        kosaraju(graph, v);
    }
}
