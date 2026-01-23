import java.util.HashMap;

class LRUCache {
    HashMap<Integer,Dll> map;
    Dll head,tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head= new Dll(-1001,-1001);
        tail= new Dll(1001,1001);
        head.next=tail;
        tail.prev=head;
        map= new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
           Dll node= map.get(key);
           detach(node);
           bringToFront(node);
           return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Dll node = map.get(key);
            node.val = value;
            detach(node);
            bringToFront(node);
        } else {
            if (map.size() == capacity) {
                // 1. Remove from Map
                map.remove(tail.prev.key);
                // 2. Remove from DLL
                removeLast();
            }

            // 3. Create and add new node
            Dll nnode = new Dll(key, value);
            map.put(key, nnode);
            bringToFront(nnode);
        }
    }

    public void bringToFront(Dll node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    public void detach(Dll node){
        Dll back=node.prev;
        Dll front=node.next;
        back.next=front;
        front.prev=back;
    }
    public void removeLast(){
        Dll node = tail.prev;
        System.out.println("Evicting key: " + node.key); // Add this for debugging
        detach(node);
    }



    class Dll{
        int key;
        int val;
        Dll prev;
        Dll next;

        public Dll(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 1);   // null
        cache.put(2, 2);   // null
        cache.put(3, 3);   // null

        System.out.println(cache.get(1)); // 1
        System.out.println(cache.get(2)); // 2
        System.out.println(cache.get(4)); // -1

        cache.put(4, 4);   // null

        System.out.println(cache.get(1)); // 1
        System.out.println(cache.get(2)); // 2
        System.out.println(cache.get(3)); // -1
        System.out.println(cache.get(4)); // 4
        System.out.println(cache.get(2)); // 2

        cache.put(1, 8);   // null
        cache.put(3, 7);   // null

        System.out.println(cache.get(1)); // 8
        System.out.println(cache.get(2)); // 2
        System.out.println(cache.get(3)); // 7
        System.out.println(cache.get(4)); // -1
        System.out.println(cache.get(5)); // -1

        System.out.println(cache.get(2)); // 2
        System.out.println(cache.get(3)); // 7
        System.out.println(cache.get(4)); // -1

        cache.put(1, 9);   // null
        cache.put(6, 6);   // null

        System.out.println(cache.get(1)); // 9
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 7
        System.out.println(cache.get(4)); // -1
        System.out.println(cache.get(5)); // -1
        System.out.println(cache.get(6)); // 6
    }




}