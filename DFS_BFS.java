import java.util.*;

class Node {
    int id;
    int cost;
    Node parent;

    public Node(int id, int cost, Node parent) {
        this.id = id;
        this.cost = cost;
        this.parent = parent;
    }
}

class Graph {
    int V;
    LinkedList<Node>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v, int cost) {
        adj[u].add(new Node(v, cost, null));
    }

    public void BFS(int s) {

        boolean[] visited = new boolean[V];

        Queue<Node> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(new Node(s, 0, null));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.id + " ");
            for (Node n : adj[node.id]) {
                if (!visited[n.id]) {
                    visited[n.id] = true;
                    n.parent = node;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[V];

        Stack<Node> stack = new Stack<>(); //Stack for DFS

        visited[s] = true;
        stack.push(new Node(s, 0, null));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.id + " ");
            for (Node n : adj[node.id]) {
                if (!visited[n.id]) {
                    visited[n.id] = true;
                    n.parent = node;
                    stack.push(n);
                }
            }
        }
        System.out.println();
    }

    public void printAllPaths(int s, int g) {
        List<Node> path = new ArrayList<>();

        printAllPathsUtil(s, g, path);
    }

    public void printAllPathsUtil(int s, int g, List<Node> path) {
        path.add(new Node(s, 0, null));
        if (s == g) {
            System.out.print("Path: ");
            for (Node n : path) {
                System.out.print(n.id + " ");
            }
            System.out.println();
        } else {
            for (Node n : adj[s]) {
                if (!path.contains(n)) {
                    printAllPathsUtil(n.id, g, path);
                }
            }
        }

        path.remove(path.size() - 1);
    }

    // A method to find the optimal path from the source node to the goal node based on the path costs by comparing all possible paths
public void findOptimalPath(int s, int g) {
    List<Node> path = new ArrayList<>();//list to store the current path

    List<List<Node>> paths = new ArrayList<>();//list to store all the possible paths

    findAllPaths(s, g, path, paths);

    List<Node> optimalPath = null;
    int optimalCost = Integer.MAX_VALUE;

    for (List<Node> p : paths) {
        int pathCost = 0;
        for (int i = 0; i < p.size() - 1; i++) {
            pathCost += p.get(i).cost;
        }
        if (pathCost < optimalCost) {
            optimalPath = p;
            optimalCost = pathCost;
        }
    }

    System.out.print("Optimal path: ");
    for (Node n : optimalPath) {
        System.out.print(n.id + " ");
    }
    System.out.println();
    System.out.println("Optimal cost: " + optimalCost);
}

public void findAllPaths(int s, int g, List<Node> path, List<List<Node>> paths) {
    path.add(new Node(s, 0, null));

    if (s == g) {
        paths.add(new ArrayList<>(path));
    } else {
        for (Node n : adj[s]) {
            if (!path.contains(n)) {
                findAllPaths(n.id, g, path, paths);
            }
        }
    }

    path.remove(path.size() - 1); //Removing the current node from path
}

    public void printPath(Node node) {
        if (node.parent != null) {
            printPath(node.parent);
        }
        System.out.print(node.id + " ");
    }
}

class Assignment{
    public static void main(String[] args) {
        Graph g = new Graph(10);

        g.addEdge(0, 1, 2); // AB=2
        g.addEdge(0, 2, 4); // AC=4
        g.addEdge(0, 3, 3); // AD=3
        g.addEdge(0, 4, 1); // AE=1
        g.addEdge(1, 2, 4); // BC=4
        g.addEdge(1, 6, 1); // BG=1
        g.addEdge(2, 6, 2); // CG=2
        g.addEdge(2, 4, 5); // CE=5
        g.addEdge(2, 3, 6); // CD=6
        g.addEdge(2, 7, 3); // CH=3
        g.addEdge(3, 4, 2); // DE=2
        g.addEdge(3, 8, 1); // DI=1
        g.addEdge(4, 9, 3); // EJ=3
        g.addEdge(7, 8, 1); // HI=1
        g.addEdge(8, 9, 1); // IJ=1

        System.out.println("BFS traversal from node A (0):");
        g.BFS(0);

        System.out.println("DFS traversal from node A (0):");
        g.DFS(0);

        System.out.println("All the possible paths from node A (0) to node I (8):");
        g.printAllPaths(0, 8);

        System.out.println("The optimal path from node A (0) to node I (8) based on the path costs:");
        g.findOptimalPath(0, 8);
    }
}
