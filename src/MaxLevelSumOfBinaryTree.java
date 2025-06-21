import java.util.Arrays;
import java.util.Collections;

public class MaxLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
    int []arr = new int[100];
        Arrays.fill(arr,-100001);
        dfs(root,0,arr);
        int maxIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return  maxIdx+1;
    }
    public void dfs(TreeNode root,int level,int []arr){
        if(root==null){
            return;
        }
        if(arr[level]==-100001){
            arr[level]=  root.val;
        }
        else
         arr[level]+=root.val;
        dfs(root.left,level+1,arr);
        dfs(root.right,level+1,arr);
    }
    public static void main(String[] args) {
        // Test case: Tree: [-100,-200,-300,-20,-5,-10,null]
        TreeNode t = new TreeNode(-100,
                new TreeNode(-200,
                        new TreeNode(-20),
                        new TreeNode(-5)
                ),
                new TreeNode(-300,
                        new TreeNode(-10),
                        null
                )
        );
        MaxLevelSumOfBinaryTree solution = new MaxLevelSumOfBinaryTree();
        System.out.println(solution.maxLevelSum(t)); // Expected: 3 (level 3 with sum = -20 + -5 + -10 = -35)
    }


}
