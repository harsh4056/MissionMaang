import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeSideView {

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> bfsQueue= new ArrayDeque<>();
        List<Integer> rightSideView= new ArrayList<>();
        if(root==null){
            return rightSideView;
        }
        bfsQueue.add(root);
        while(!bfsQueue.isEmpty()){
            int size= bfsQueue.size();
            for (int i = 0; i < size; i++) {
                    TreeNode curr=bfsQueue.remove();
                 if(i==size-1){
                     rightSideView.add(curr.val);
                 }
                 if(curr.left!=null){
                     bfsQueue.add(curr.left);
                 }
                if(curr.right!=null){
                    bfsQueue.add(curr.right);
                }
            }
        }
        return  rightSideView;
    }
}
