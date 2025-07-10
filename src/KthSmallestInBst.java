public class KthSmallestInBst {

    public int kthSmallest(TreeNode root, int k) {
       int[]ans= new int[]{-1};
       int[]kArr= new int[]{k};
        findSmallest(root,kArr,ans);
       return ans[0];
    }

    public void  findSmallest(TreeNode root,int[]k,int []ans){
        if(root==null){
            return;
        }
        if(k[0]>0) {
            findSmallest(root.left, k, ans);
            k[0]--;
            if(k[0]==0){
                ans[0]=root.val;
                return;
            }
            findSmallest(root.right, k, ans);
        }
    }

    public static void main(String[] args) {
        KthSmallestInBst solution = new KthSmallestInBst();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println(solution.kthSmallest(root1, 1)); // Expected: 1

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        System.out.println(solution.kthSmallest(root2, 3)); // Expected: 3

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(1);
        System.out.println(solution.kthSmallest(root3, 2)); // Expected: 2
    }


}
