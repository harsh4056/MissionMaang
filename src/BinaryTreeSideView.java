import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> listView= new ArrayList<>();

        dfs(root,0,listView);

        return listView;

    }

    public void dfs(TreeNode root,int level,List<Integer> listRightView){
        if(root==null){
            return;
        }
        if( listRightView.size()==level){
            listRightView.add(root.val);

        }
        dfs(root.right,level+1,listRightView);
        dfs(root.left,level+1,listRightView);
    }

    public static void main(String[] args) {
        // Test case: Tree: [1,2,3,4,null,null,null,5]
        TreeNode t = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(5), null
                        ),
                        null
                ),
                new TreeNode(3)
        );
        BinaryTreeSideView solution = new BinaryTreeSideView();
        System.out.println(solution.rightSideView(t)); // Expected: [1, 3, 4, 5]
    }


}
