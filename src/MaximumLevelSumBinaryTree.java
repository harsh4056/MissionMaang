import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumLevelSumBinaryTree {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue= new ArrayDeque<>();
        Queue<Integer> queueLevel= new ArrayDeque<>();
        queueLevel.offer(1);
        queue.offer(root);
        int maxi=Integer.MIN_VALUE;
        int sum=Integer.MIN_VALUE;
        int lastLevel=0;
        int level=-1;
        int mLevel=-1;
        while (!queue.isEmpty()){
            level=queueLevel.poll();
            TreeNode curr= queue.poll();
            if(lastLevel!=level){
                if(maxi<sum){
                    maxi=sum;
                    mLevel=lastLevel;
                }
                sum=0;
                lastLevel=level;
            }
            sum+=curr.val;
            if(curr.left!=null){
                queueLevel.offer(level+1);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                queueLevel.offer(level+1);
                queue.offer(curr.right);
            }
        }
        if(maxi<sum){
            maxi=sum;
            mLevel=level;

        }
        return mLevel;
    }

    public static void main(String[] args) {

        MaximumLevelSumBinaryTree solution = new MaximumLevelSumBinaryTree();

        // Test Case
        // Tree: [-100,-200,-300,-20,-5,-10,null]
        // Level 1 sum = -100
        // Level 2 sum = -200 + -300 = -500
        // Level 3 sum = -20 + -5 + -10 = -35
        // Expected Output: 3
        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);
        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-5);
        root.right.left = new TreeNode(-10);

        System.out.println(solution.maxLevelSum(root)); // 3
    }

}
