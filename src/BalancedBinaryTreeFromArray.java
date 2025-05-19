public class BalancedBinaryTreeFromArray {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0, nums.length-1);
    }
    public TreeNode buildTree(int[]nums,int left,int right){

        if(left>right)
            return null;
        int mid=left+(right-left)/2;

        TreeNode node= new TreeNode(nums[mid]);
        node.left=buildTree(nums,left,mid-1);
        node.right=buildTree(nums,mid+1,right);
        return node;
    }

    public static void main(String[] args) {
        BalancedBinaryTreeFromArray solution = new BalancedBinaryTreeFromArray();
        TreeNode node=solution.sortedArrayToBST(new int[]{3,6,8,12,31});
        System.out.println();
    }
}
