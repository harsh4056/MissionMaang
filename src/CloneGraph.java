import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> hashMap= new HashMap<>();
        dfsStoreHashMap(node,hashMap);
        Node newNodeRoot= hashMap.get(node);

        for (Map.Entry<Node, Node> nodeNodeEntry : hashMap.entrySet()) {
            for (Node current : nodeNodeEntry.getKey().neighbors) {
                nodeNodeEntry.getValue().neighbors.add(hashMap.get(current));
            }
        }
        return newNodeRoot;
    }

    public void dfsStoreHashMap(Node node, HashMap<Node,Node> hashMap){
        if (!hashMap.containsKey(node)){
            hashMap.put(node,new Node(node.val));
            List<Node> nodes= node.neighbors;
            for (Node current : nodes) {
                dfsStoreHashMap(current,hashMap);
            }
        }
    }




    public static void main(String[] args) {
        // Build the graph manually
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        /*node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);*/

        CloneGraph sol = new CloneGraph();
        Node clone = sol.cloneGraph(new Node(1));

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