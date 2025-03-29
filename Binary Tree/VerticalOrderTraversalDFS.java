import java.util.*;

class VerticalOrderTraversalDFS { // Top-view approach

    static class Node {
        int val;
        Node right, left;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;
    static Queue<Node> q = new LinkedList<>();

    static void buildTree(int[] nodes) {
        if (nodes.length == 0) return;
        root = new Node(nodes[0]);
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < nodes.length) {
            Node current = q.poll();
            if (nodes[i] != -1) {
                current.left = new Node(nodes[i]);
                q.add(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != -1) {
                current.right = new Node(nodes[i]);
                q.add(current.right);
            }
            i++;
        }
    }

    static void verticalOrder(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        dfs(root, map, 0, 0);

        System.out.print("Vertical Order: ");
        for (List<Integer> values : map.values()) {
            for (int val : values) {
                System.out.print(val + " ");
            }
        }
    }

    static void dfs(Node root, Map<Integer, List<Integer>> map, int hd, int level) {
        if (root == null) return;

        // Add the current node value to the list at this horizontal distance
        map.putIfAbsent(hd, new ArrayList<>());
        map.get(hd).add(root.val);

        dfs(root.left, map, hd - 1, level + 1);
        dfs(root.right, map, hd + 1, level + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        int[] nodes = new int[n];
        System.out.println("Enter the nodes: ");
        for (int i = 0; i < n; i++) {
            nodes[i] = input.nextInt();
        }
        buildTree(nodes);
        verticalOrder(root);
    }
}
