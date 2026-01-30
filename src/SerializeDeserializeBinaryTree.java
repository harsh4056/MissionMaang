import com.sun.source.tree.Tree;

import java.util.*;
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder store= new StringBuilder();
        if(root==null) return store.toString();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr= queue.poll();
            if(curr==null){
                store.append("#");
                store.append(",");
                continue;
            }
            store.append(curr.val);
            store.append(",");

            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return store.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(Objects.equals(data, "")) return null;
        String[] order=data.split(",");

        Queue<TreeNode> q= new LinkedList<>();
        TreeNode root= new TreeNode(Integer.parseInt(order[0]));
        q.offer(root);
        for (int i = 1; i < order.length; i++) {
            TreeNode curr= q.poll();
            if(!Objects.equals(order[i], "#")){
                int val=Integer.parseInt(order[i]);
                curr.left=new TreeNode(val);
                q.offer(curr.left);
            }
            if(!Objects.equals(order[++i], "#")){
                int val=Integer.parseInt(order[i]);
                curr.right=new TreeNode(val);
                q.offer(curr.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();

        TreeNode root4 = null;


        String s4 = obj.serialize(root4);
        System.out.println(s4); // expected: 1,2,#,3,#,#,#,

        TreeNode d4 = obj.deserialize(s4);
        System.out.println(obj.serialize(d4)); // expected: same as above

        // Test case 1: Normal binary tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        String s1 = obj.serialize(root1);
        System.out.println(s1); // expected: 1,2,3,#,#,4,5,#,#,#,#,

        TreeNode d1 = obj.deserialize(s1);
        System.out.println(obj.serialize(d1)); // expected: same as above


        // Test case 2: Single node tree
        TreeNode root2 = new TreeNode(10);

        String s2 = obj.serialize(root2);
        System.out.println(s2); // expected: 10,#,#,

        TreeNode d2 = obj.deserialize(s2);
        System.out.println(obj.serialize(d2)); // expected: 10,#,#,


        // Test case 3: Left skewed tree
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);

        String s3 = obj.serialize(root3);
        System.out.println(s3); // expected: 1,2,#,3,#,#,#,

        TreeNode d3 = obj.deserialize(s3);
        System.out.println(obj.serialize(d3)); // expected: same as above


    }

}
