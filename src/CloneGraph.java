import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> hashMap= new HashMap<>();

        HashSet<Node> visited= new HashSet<>();
        Queue<Node> bfsQueue= new LinkedList<>();

        bfsQueue.offer(node);
        while(!bfsQueue.isEmpty()){
            Node curr= bfsQueue.poll();
            if(visited.contains(curr)) continue;
            visited.add(curr);
            if(!hashMap.containsKey(curr)){
                Node temp= new Node(curr.val);
                hashMap.put(curr,temp);
            }
            Node node_dash= hashMap.get(curr);
            for(Node n:curr.neighbors){
                if(!visited.contains(n)) {
                    bfsQueue.offer(n);
                }
                hashMap.putIfAbsent(n, new Node(n.val));
                node_dash.neighbors.add(hashMap.get(n));
            }


        }
        return hashMap.get(node);
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