public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(isSameTree(root,subRoot)) return true;
        else{
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null ||q==null) return false;

        if(p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right,q.right)){
            return true;
        }
        return false;

    }



    public static void main(String[] args) {
        SubTreeOfAnotherTree sol = new SubTreeOfAnotherTree();
        // Example 1
        // root = [1,2,3,4,5]
        // subRoot = [2,4,5]
        /*TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        TreeNode subRoot1 = new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5));

        System.out.println(sol.isSubtree(root1, subRoot1)); // true*/


        // Example 2
        // root = [1,2,3,4,5,null,null,6]
        // subRoot = [2,4,5]
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(6),
                                null),
                        new TreeNode(5)),
                new TreeNode(3));

        TreeNode subRoot2 = new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5));

        System.out.println(sol.isSubtree(root2, subRoot2)); // false


    }

}
