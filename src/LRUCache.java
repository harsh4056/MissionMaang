import java.util.HashMap;

class LRUCache {
    Dll head, tail;
    int size;
    int curr;
    HashMap<Integer, Dll> map;

    public LRUCache(int capacity) {
        head = new Dll(-1001, -1001,null,null);
        tail = new Dll(-1001, -1001,null,null);
        head.next = tail;
        tail.prev = head;
        size = capacity;
        curr = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Dll node = map.get(key);
            detach(node);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Dll node = map.get(key);
            node.value = value;
        } else {
            if (curr == size) {
                Dll node = tail.prev;
                detach(node);
                map.remove(node.key);
            } else {
                curr++;
            }
            Dll node = new Dll(key, value, null, null);
            moveToFront(node);
        }

    }

    public void detach(Dll node) {
        Dll prev = node.prev;
        Dll next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToFront(Dll node) {
        Dll oldFirst = head.next;
        oldFirst.prev = node;
        head.next = node;
        node.prev = head;
        node.next = oldFirst;
    }

    class Dll {
        int key;
        int value;
        Dll prev;
        Dll next;

        Dll(int key, int value, Dll prev, Dll next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
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