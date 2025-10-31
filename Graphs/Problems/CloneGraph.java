/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph { //create a deep copy of the given graph
    public Node cloneGraph(Node node) {
        Queue<Node> q = new LinkedList<>();

        if(node == null){
            return node;
        }

        q.add(node);

        Map<Node, Node> map = new HashMap<>();
        Node current;

        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node, newNode);
        
        while(!q.isEmpty()){
            current = q.poll();
            Node currentClone = map.get(current);

            for(Node neighboringNode : current.neighbors){
                if(map.containsKey(neighboringNode)){
                    currentClone.neighbors.add(map.get(neighboringNode));
                }
                else{
                    Node newCloneNeighbor = new Node(neighboringNode.val);
                    map.put(neighboringNode, newCloneNeighbor);
                    q.add(neighboringNode);
                    currentClone.neighbors.add(newCloneNeighbor);
                }
            }
        }

        return map.get(node);
    }
}
