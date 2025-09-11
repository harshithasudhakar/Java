/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class ConstructQuadTree {
    int n;
    
    public Node construct(int[][] grid) {
        n = grid.length;

        return checkIsLeaf(grid, 0, 0, n - 1, n - 1);
    }

    Node checkIsLeaf(int[][] grid, int sR, int sC, int eR, int eC) {
        Node root;
        int count = 0;
        for (int i = sR; i <= eR; i++) {
            for (int j = sC; j <= eC; j++) {
                if (grid[i][j] != 0) {
                    count += 1;
                }
            }
        }

        if (count == (eR - sR + 1) * (eC - sC + 1)) {
            root = new Node(true, true);
        } else if (count == 0) {
            root = new Node(false, true);
        } else {
            root = new Node(false, false);
        }

        if (root.isLeaf == false) {
            int midRow = (sR + eR) / 2;
            int midCol = (sC + eC) / 2;

            root.topLeft = checkIsLeaf(grid, sR, sC, midRow, midCol);
            root.topRight = checkIsLeaf(grid, sR, midCol + 1, midRow, eC);
            root.bottomLeft = checkIsLeaf(grid, midRow + 1, sC, eR, midCol);
            root.bottomRight = checkIsLeaf(grid, midRow + 1, midCol + 1, eR, eC);
        }
        return root;
    }
}
