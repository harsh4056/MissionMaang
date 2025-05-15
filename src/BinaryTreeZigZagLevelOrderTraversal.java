import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  listList= new ArrayList<>();
        if(root==null)
            return listList;
        Queue<TreeNode> queue= new ArrayDeque<>();
        queue.add(root);
        boolean reverse= false;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list= new ArrayList<>();
            Stack<TreeNode> tempStack= new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr= queue.remove();
                if(!reverse) {
                    list.add(curr.val);
                }
                else{
                    tempStack.add(curr);
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }

            }
            if(reverse){
                for (int i = 0; i < size; i++) {
                    TreeNode curr= tempStack.pop();
                        list.add(curr.val);
                }
            }
            reverse=!reverse;
            listList.add(list);

        }
        return listList;
    }
    public static void main(String[] args) {
        // Level 2
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        // Level 1
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20, node15, node7);

        // Root
        TreeNode root = new TreeNode(3, node9, node20);

        // Now root represents the tree
        // You can call your function here:
        BinaryTreeZigZagLevelOrderTraversal sol = new BinaryTreeZigZagLevelOrderTraversal();
        List<List<Integer>> result = sol.zigzagLevelOrder(root);
        System.out.println(result);
    }

}
