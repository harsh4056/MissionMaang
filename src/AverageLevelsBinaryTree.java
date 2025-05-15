import java.util.ArrayList;
import java.util.List;

public class AverageLevelsBinaryTree {



    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubles= new ArrayList<>();
        traverse(root,0,doubles);
        return doubles;
    }
    public void traverse(TreeNode root,int level,List<Double> doubles){
        if(root==null)
            return;
        if(doubles.size()==level){
            doubles.add(0.0);
        }
        doubles.set(level,doubles.get (level)+(double) root.val);
        traverse(root.left,level+1,doubles);
        traverse(root.right,level+1,doubles);

    }


    public static void main(String[] args) {
        // Level 0
        TreeNode root = new TreeNode(1);

        // Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        // Level 2
        root.left.left = new TreeNode(3);
        // root.left.right = null;
        // root.right.left = null;
        root.right.right = new TreeNode(3);

        // Level 3
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        AverageLevelsBinaryTree tree= new AverageLevelsBinaryTree();
        tree.averageOfLevels(root);

    }

}
