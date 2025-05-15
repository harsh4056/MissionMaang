import java.util.HashMap;

class LRUCache {

    int capacity=0;
    int size=0;
    LinkedListCache head=null;
    LinkedListCache tail=null;

    HashMap<Integer,LinkedListCache> integerNodeMap= new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedListCache(0, 0, null, null);
        tail = new LinkedListCache(0, 0, null, null);
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        if (!integerNodeMap.containsKey(key)) {
            return -1;
        }
        LinkedListCache node = integerNodeMap.get(key);
        moveToFront(node);
        return node.value;
    }


    public void put(int key, int value) {
        if (integerNodeMap.containsKey(key)) {
            LinkedListCache node = integerNodeMap.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            if (integerNodeMap.size() == capacity) {
                // remove from linked list and hashmap
                LinkedListCache lru = tail.prev;
                removeNode(lru);
                integerNodeMap.remove(lru.key);
            }
            LinkedListCache newNode = new LinkedListCache(key, value, null, null);
            integerNodeMap.put(key, newNode);
            addToFront(newNode);
        }
    }


    class LinkedListCache {
        int key=0;
        int value=0;
        LinkedListCache next;
        LinkedListCache prev;

        public LinkedListCache(int key, int value, LinkedListCache next, LinkedListCache prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    // Always add node right after head
    private void addToFront(LinkedListCache node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Remove an existing node
    private void removeNode(LinkedListCache node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move an existing node to the front
    private void moveToFront(LinkedListCache node) {
        removeNode(node);
        addToFront(node);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));    // Expected 1
        lRUCache.put(3, 3);                     // Evicts key 2
        System.out.println(lRUCache.get(2));    // Expected -1
        lRUCache.put(4, 4);                     // Evicts key 1
        System.out.println(lRUCache.get(1));    // Expected -1
        System.out.println(lRUCache.get(3));    // Expected 3
        System.out.println(lRUCache.get(4));    // Expected 4

    }
}