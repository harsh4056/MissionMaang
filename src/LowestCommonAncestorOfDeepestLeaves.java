public class LowestCommonAncestorOfDeepestLeaves {
    int dLevel=0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dLevel=0;
        getDeepestLevel(root,0);
        TreeNode result= solve(root,0);
        return result;
    }

    public void getDeepestLevel(TreeNode root,int level){
        if(root==null) return ;
        dLevel=Math.max(dLevel,level);
        getDeepestLevel(root.left ,level+1);
        getDeepestLevel(root.right,level+1);
    }
    public TreeNode solve(TreeNode root,int level){
        if(root==null) return null;


        TreeNode left= solve(root.left ,level+1);
        TreeNode right=solve(root.right,level+1);
        if(level==dLevel ){
            return root;
        }

        if(left!=null && right!=null)
            return root;
        else if(left!=null || right!=null){
            if(left==null) return right;
            else return left;
        }
        return null;

    }
    public static void main(String[] args) {
        LowestCommonAncestorOfDeepestLeaves sol = new LowestCommonAncestorOfDeepestLeaves();

        // Test case 1:
        // Input: [3,5,1,6,2,0,8,null,null,7,4]
        // Expected output: 2
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode ans1 = sol.lcaDeepestLeaves(root1);
        System.out.println(ans1.val); // Expected: 2


        // Test case 2:
        // Input: [1]
        // Expected output: 1
        TreeNode root2 = new TreeNode(1);

        TreeNode ans2 = sol.lcaDeepestLeaves(root2);
        System.out.println(ans2.val); // Expected: 1


        // Test case 3:
        // Input: [0,1,3,null,2]
        // Expected output: 2
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);
        root3.left.right = new TreeNode(2);

        TreeNode ans3 = sol.lcaDeepestLeaves(root3);
        System.out.println(ans3.val); // Expected: 2
    }


}
