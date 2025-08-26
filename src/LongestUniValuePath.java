public class LongestUniValuePath {


    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        max=0;
        findLongest(root);
        return max;
    }
    public Node findLongest(TreeNode root){
        if(root == null) return new Node(null,0);
        Node left=findLongest(root.left);
        Node right=findLongest(root.right);
        int leftC=left.len;
        int rightC=right.len;
        if(left.root!=null && root.val==left.root.val){
            leftC++;
        }
        else{
            leftC=0;
        }
        if(right.root!=null && root.val==right.root.val){
            rightC++;
        }
        else{
            rightC=0;
        }
        max=Math.max(max,leftC+rightC);

        if(leftC>rightC){
            return new Node(root,leftC);
        }
        else{
            return new Node(root,rightC);
        }

    }
    class Node{
        TreeNode root;
        int len=0;
        Node(){
            len=0;
            root=null;
        }
        Node(TreeNode node,int length){
            len=length;
            root=node;
        }
    }
    public static void main(String[] args) {
        LongestUniValuePath sol = new LongestUniValuePath();

        // Test case: [1, 1, 2, null, null, null, 2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);

        System.out.println(sol.longestUnivaluePath(root));
        // Expected: 2
    }





}
