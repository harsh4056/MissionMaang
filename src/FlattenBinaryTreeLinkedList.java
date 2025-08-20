import com.sun.source.tree.Tree;

public class FlattenBinaryTreeLinkedList {


    TreeNode head=null;
    public void flatten(TreeNode root) {
        head=new TreeNode();
        flat(root);
    }
    public TreeNode flat(TreeNode root){
        if(root==null) return null;


        TreeNode right=flat(root.right);
        TreeNode left=flat(root.left);
        System.out.println(root.val);

        return root;

    }

    public static void main(String[] args) {
        // Construct tree: [1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTreeLinkedList solution = new FlattenBinaryTreeLinkedList();
        solution.flatten(root) ;

        // Print result as right-skewed list
        TreeNode current = root;
        while (current != null) {
            System.out.println();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

}
