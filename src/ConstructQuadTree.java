public class ConstructQuadTree {

    public Node construct(int[][] grid) {
            Node root= divideAndConquer(grid, grid.length, 0,0);
            return root;
    }

    public Node divideAndConquer(int[][] grid,int n,int i,int j){

        if(n==0){
            return null;
        }
        if(n==1){
            Node root= new Node(grid[i][j]==1,true);
            return root;
        }




        Node root= new Node();
        root.topLeft = divideAndConquer(grid, n/2, i, j);
        root.topRight = divideAndConquer(grid, n/2, i, j + n/2);
        root.bottomLeft = divideAndConquer(grid, n/2, i + n/2, j);
        root.bottomRight = divideAndConquer(grid, n/2, i + n/2, j + n/2);

        if (root.topLeft.isLeaf && root.topRight.isLeaf &&
                root.bottomLeft.isLeaf && root.bottomRight.isLeaf) {

            boolean allTrue = root.topLeft.val && root.topRight.val &&
                    root.bottomLeft.val && root.bottomRight.val;

            boolean allFalse = !root.topLeft.val && !root.topRight.val &&
                    !root.bottomLeft.val && !root.bottomRight.val;

            if (allTrue || allFalse) {
                root.isLeaf = true;
                root.val = allTrue;
                root.topLeft = root.topRight = root.bottomLeft = root.bottomRight = null;
            }
        }



        return root;
    }



    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        ConstructQuadTree tree= new ConstructQuadTree();
        Node root=tree.construct(grid);


        printQuadTree(root, 0);
    }

    public static void printQuadTree(Node node, int level) {
        if (node == null) return;

        String indent = "  ".repeat(level);
        System.out.println(indent + "Node(val=" + node.val + ", isLeaf=" + node.isLeaf + ")");

        if (!node.isLeaf) {
            printQuadTree(node.topLeft, level + 1);
            printQuadTree(node.topRight, level + 1);
            printQuadTree(node.bottomLeft, level + 1);
            printQuadTree(node.bottomRight, level + 1);
        }
    }



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

}
