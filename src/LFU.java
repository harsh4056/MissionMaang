class LFUCache {
    int capacity=0;
    int size=0;
    LinkedListCache head=null;
    LinkedListCache tail=null;

    public LFUCache(int capacity) {

    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

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





}
