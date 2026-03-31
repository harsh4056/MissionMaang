import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        HashMap<Node,Node> map= new HashMap<>();
        HashSet<Node> visited= new HashSet<>();
        Queue<Node> queue= new LinkedList<>();
        Node root= new Node(node.val);
        map.put(node,root);
        queue.offer(node);
        while(!queue.isEmpty()){
            Node curr= queue.poll();
            Node bNode=map.get(curr);

            for(Node nei:curr.neighbors){
                if(!map.containsKey(nei)){
                    Node temp= new Node(nei.val);
                    map.put(nei,temp);
                }

                bNode.neighbors.add(map.get(nei));
                if(!visited.contains(nei)){
                    queue.offer(nei);
                }
            }
            visited.add(curr);

        }
        return root;


    }





    public static void main(String[] args) {
        // Build the graph manually
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph sol = new CloneGraph();
        Node clone = sol.cloneGraph(node1);

        printGraph(clone, new HashSet<>());
    }

    private static void printGraph(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) return;
        visited.add(node.val);
        System.out.print("Node " + node.val + " neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();
        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}