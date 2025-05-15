import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  listList= new ArrayList<>();
        if(root==null)
            return listList;
        Queue<TreeNode> queue= new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr= queue.remove();
                list.add(curr.val);
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            listList.add(list);

        }
        return listList;
    }

}
