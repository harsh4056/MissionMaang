import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(0, 0); // dummy head
            tail = new Node(0, 0); // dummy tail
            head.next = tail;
            tail.prev = head;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity, size, minFreq;
    Map<Integer, Node> keyNodeMap = new HashMap<>();
    Map<Integer, DLL> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) return -1;
        Node node = keyNodeMap.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            update(node);
        } else {
            if (size == capacity) {
                DLL minFreqList = freqMap.get(minFreq);
                Node toRemove = minFreqList.removeTail();
                keyNodeMap.remove(toRemove.key);
                size--;
            }

            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, z -> new DLL()).addToHead(newNode);
            minFreq = 1;
            size++;
        }
    }

    private void update(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, z -> new DLL()).addToHead(node);
    }
}
