import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepthBinaryTree {


    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue= new ArrayDeque<>();

        queue.offer(root);
        root.val=1;
        while (!queue.isEmpty()){

            TreeNode current =queue.poll();
            if(current.right==null && current.left==null){
                return current.val;
            }



            if(current.left!=null){
                current.left.val=current.val+1;
                queue.offer(current.left);
            }

            if(current.right!=null){
                current.right.val=current.val+1;
                queue.offer(current.right);
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        MinimumDepthBinaryTree tree = new MinimumDepthBinaryTree();

        // Test Case 1: Balanced tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Test Case 1 Output: " + tree.minDepth(root1));

        // Test Case 2: Single node tree
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test Case 2 Output: " + tree.minDepth(root2));

        // Test Case 3: Left skewed tree
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        System.out.println("Test Case 3 Output: " + tree.minDepth(root3));


        // Test Case 4: Right skewed tree
        TreeNode root4 = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.right.right = new TreeNode(4);
        root4.right.right.right = new TreeNode(5);
        root4.right.right.right.right = new TreeNode(6);
        System.out.println("Test Case 4 Output: " + tree.minDepth(root4));
    }
}


