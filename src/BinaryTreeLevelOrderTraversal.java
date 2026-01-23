
import java.util.*;

public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> queuel=new LinkedList<>();
        List<List<Integer>> answer= new ArrayList<>();
        if(root==null) return answer;
        queue.offer(root);
        queuel.offer(0);
        int lastLevel=0;
        List<Integer> list= new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            int level=queuel.poll();
            if(node.left!=null){
                queue.offer(node.left);
                queuel.offer(level+1);
            }
            if(node.right!=null){
                queue.offer(node.right);
                queuel.offer(level+1);
            }
            if(lastLevel==level){
                list.add(node.val);
            }
            else{
                lastLevel=level;
                answer.add(list);
                list=new ArrayList<>();
                list.add(node.val);
            }
        }
        answer.add(list);

        return answer;


    }
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();

        // Test case 1
        // root = [3,9,20,null,null,15,7]
        // Expected Output: [[3],[9,20],[15,7]]
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        System.out.println(obj.levelOrder(root1));


        // Test case 2
        // root = [1]
        // Expected Output: [[1]]
        TreeNode root2 = new TreeNode(1);

        System.out.println(obj.levelOrder(root2));


        // Test case 3
        // root = []
        // Expected Output: []
        TreeNode root3 = null;

        System.out.println(obj.levelOrder(root3));
    }


}
