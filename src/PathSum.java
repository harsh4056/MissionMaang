public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root.left==null && root.right==null){
            return targetSum-root.val==0;
        }
        else {
          return   hasPathSum(root.right,targetSum-root.val) ||
            hasPathSum(root.left,targetSum-root.val);
        }
    }
}
