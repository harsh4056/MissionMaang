import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumRootLeafNumbers {

    /*Stack<Integer> integerStack= new Stack<>();
    List<Integer> longs= new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int sum=0;
        getDigits(root);
        for (int l : longs) {
            sum+=l;
        }
        return sum;
    }

    public void getDigits(TreeNode root){
        if(root==null)
            return;
        integerStack.push(root.val);
        if(root.right==null && root.left==null){
            int sum=0;

            for (Integer integer : integerStack) {

                sum=sum*10 +integer;
            }

            longs.add(sum);

        }

        getDigits(root.left);
        getDigits(root.right);
        integerStack.pop();
    }*/


    public void getresult(TreeNode root, int[] result, int tempresult) {
        if (root == null) {
            return;
        }
        tempresult = tempresult * 10 + root.val;
        if (root.left == null && root.right == null) {
            result[0] += tempresult;
            return;
        }
        getresult(root.left, result, tempresult);
        getresult(root.right, result, tempresult);
    }

    public int sumNumbers(TreeNode root) {
        int[] result = new int[1]; // Using an array to hold the result
        int tempresult = 0;
        getresult(root, result, tempresult);
        return result[0];
    }








    public static void main(String[] args) {
        // Build the tree [4,9,0,5,1]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Test the SumRootLeafNumbers class
        SumRootLeafNumbers solution = new SumRootLeafNumbers();

        int result = solution.sumNumbers(root);
        System.out.println("Sum of root-to-leaf numbers: " + result);  // Expected: 1026
    }

}
