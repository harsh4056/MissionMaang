import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer= new ArrayList<>();
        findSum(answer,new ArrayList<>(),root,targetSum);
        return answer;
    }
    public void findSum(List<List<Integer>> answer,List<Integer> holder,TreeNode root,int currentSum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){

            if( currentSum-root.val==0){
                holder.add(root.val);
                answer.add(new ArrayList<>(holder));
                holder.removeLast();
                return;
            }
        }
        holder.add(root.val);
        findSum(answer,holder,root.left,currentSum- root.val);
        findSum(answer,holder,root.right,currentSum- root.val);
        holder.removeLast();

    }

    public static void main(String[] args) {
        PathSumII solution = new PathSumII();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);
        root1.right.right.left = new TreeNode(5);
        System.out.println(solution.pathSum(root1, 22));
        // Expected: [[5,4,11,2],[5,8,4,5]]

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(solution.pathSum(root2, 5));
        // Expected: []

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        System.out.println(solution.pathSum(root3, 3));
        // Expected: [[1,2]]
    }

}
