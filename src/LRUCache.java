import java.util.HashMap;

class LRUCache {

    DLL dummyHead;
    DLL dummyTail;
    int capacity=0;
    int size=0;
    HashMap<Integer,DLL> map= new HashMap<>();
    public LRUCache(int capacity) {
        dummyHead =new DLL(10001,100001);
        dummyTail =new DLL(10001,100001);
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
        this.capacity=capacity;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            DLL node=map.get(key);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLL node=map.get(key);
            node.value=value;
            moveToFront(node);

        }
        else{
            DLL node = new DLL(key,value);

            addToFront(node);
            map.put(key,node);

            if(size>=capacity){
              DLL lru=  removeFromEnd();
              map.remove(lru.key);
            }
            size++;
        }
    }

    public void moveToFront(DLL node){
        node=detach(node);
        DLL currentHead =dummyHead.next;
        currentHead.prev=node;
        node.next=currentHead;
        dummyHead.next=node;
    }
    public void addToFront( DLL node){
        DLL previousNode=dummyHead;
        DLL nextNode=dummyHead.next;
        previousNode.next=node;
        nextNode.prev=node;

        node.next=nextNode;
        node.prev=previousNode;


    }

    public DLL detach(DLL node){
        DLL nodePrev=node.prev;
        DLL nodeNext=node.next;
        nodePrev.next=nodeNext;
        nodeNext.prev=nodePrev;
        return node;

    }
    public DLL removeFromEnd(){
        DLL lru=dummyTail.prev;
        detach(lru);
        System.gc();
        return lru;
    }


    class DLL{

        DLL prev;
        DLL next;
        int value;
        int key;
        public DLL(DLL prev, DLL next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        public DLL(int key,int value) {
            this.value = value;
            this.key = key;
        }
    }



    public static void main(String[] args) {
        // ✅ First small test case
        LRUCache lRUCache1 = new LRUCache(2);
        lRUCache1.put(1, 1); // cache = {1=1}
        lRUCache1.put(2, 2); // cache = {1=1, 2=2}
        System.out.println(lRUCache1.get(1)); // 1
        lRUCache1.put(3, 3); // evicts key 2 -> cache = {1=1, 3=3}
        System.out.println(lRUCache1.get(2)); // -1
        lRUCache1.put(4, 4); // evicts key 1 -> cache = {4=4, 3=3}
        System.out.println(lRUCache1.get(1)); // -1
        System.out.println(lRUCache1.get(3)); // 3
        System.out.println(lRUCache1.get(4)); // 4


        // ✅ Second large test case (capacity = 10)
        LRUCache lRUCache2 = new LRUCache(10);
        lRUCache2.put(10, 13);
        lRUCache2.put(3, 17);
        lRUCache2.put(6, 11);
        lRUCache2.put(10, 5);   // update key 10
        lRUCache2.put(9, 10);
        System.out.println(lRUCache2.get(13)); // -1
        lRUCache2.put(2, 19);
        System.out.println(lRUCache2.get(2));  // 19
        System.out.println(lRUCache2.get(3));  // 17
        lRUCache2.put(5, 25);
        System.out.println(lRUCache2.get(8));  // -1
        lRUCache2.put(9, 22);
        lRUCache2.put(5, 5);
        lRUCache2.put(1, 30);
        System.out.println(lRUCache2.get(11)); // -1
        lRUCache2.put(9, 12);
        System.out.println(lRUCache2.get(7));  // -1
        System.out.println(lRUCache2.get(5));  // 5
        System.out.println(lRUCache2.get(8));  // -1
        System.out.println(lRUCache2.get(9));  // 12
        lRUCache2.put(4, 30);
        lRUCache2.put(9, 3);
        System.out.println(lRUCache2.get(9));  // 3
        System.out.println(lRUCache2.get(10)); // 5
        System.out.println(lRUCache2.get(10)); // 5
        lRUCache2.put(6, 14);
        lRUCache2.put(3, 1);
        System.out.println(lRUCache2.get(3));  // 1
        lRUCache2.put(10, 11);
        System.out.println(lRUCache2.get(8));  // -1
        lRUCache2.put(2, 14);
        System.out.println(lRUCache2.get(1));  // 30
        System.out.println(lRUCache2.get(5));  // 5
        System.out.println(lRUCache2.get(4));  // 30
        lRUCache2.put(11, 4);
        lRUCache2.put(12, 24);
        lRUCache2.put(5, 18);
        System.out.println(lRUCache2.get(13)); // -1
        lRUCache2.put(7, 23);
        System.out.println(lRUCache2.get(8));  // -1
        System.out.println(lRUCache2.get(12)); // 24
        lRUCache2.put(3, 27);
        lRUCache2.put(2, 12);
        System.out.println(lRUCache2.get(5));  // 18
        lRUCache2.put(2, 9);
        lRUCache2.put(13, 4);
        lRUCache2.put(8, 18);
        lRUCache2.put(1, 7);
        lRUCache2.put(6, 29);
        System.out.println(lRUCache2.get(8));  // 18
        lRUCache2.put(8, 21);
        System.out.println(lRUCache2.get(5));  // 18
        lRUCache2.put(6, 30);
        lRUCache2.put(1, 12);
        System.out.println(lRUCache2.get(10)); // 11
        lRUCache2.put(4, 15);
        lRUCache2.put(7, 22);
        lRUCache2.put(11, 26);
        lRUCache2.put(8, 17);
        lRUCache2.put(9, 29);
        System.out.println(lRUCache2.get(5));  // 18
        lRUCache2.put(3, 4);
        lRUCache2.put(11, 30);
        System.out.println(lRUCache2.get(12)); // 24
        lRUCache2.put(4, 29);
        System.out.println(lRUCache2.get(3));  // 4
        System.out.println(lRUCache2.get(9));  // 29
        System.out.println(lRUCache2.get(6));  // 30
        lRUCache2.put(3, 4);
        lRUCache2.put(1, 19);
        System.out.println(lRUCache2.get(10)); // 11
        lRUCache2.put(3, 29);
        lRUCache2.put(10, 28);
        lRUCache2.put(1, 20);
        lRUCache2.put(11, 13);
        System.out.println(lRUCache2.get(3));  // 29
        System.out.println(lRUCache2.get(3));  // 29
        System.out.println(lRUCache2.get(3));  // 29
        lRUCache2.put(10, 9);
        lRUCache2.put(3, 26);
        System.out.println(lRUCache2.get(8));  // 17
        System.out.println(lRUCache2.get(7));  // 22
        System.out.println(lRUCache2.get(5));  // 18
        lRUCache2.put(13, 17);
        lRUCache2.put(2, 27);
        lRUCache2.put(11, 15);
        System.out.println(lRUCache2.get(12)); // 24
        lRUCache2.put(9, 19);
        lRUCache2.put(2, 15);
        lRUCache2.put(3, 16);
        System.out.println(lRUCache2.get(1));  // 20
        lRUCache2.put(12, 17);
        lRUCache2.put(9, 1);
        lRUCache2.put(6, 19);
        System.out.println(lRUCache2.get(4));  // 29
        System.out.println(lRUCache2.get(5));  // 18
        System.out.println(lRUCache2.get(5));  // 18
        lRUCache2.put(8, 1);
        lRUCache2.put(11, 7);
        lRUCache2.put(5, 2);
        lRUCache2.put(9, 28);
        System.out.println(lRUCache2.get(1));  // 20
        lRUCache2.put(2, 2);
        lRUCache2.put(7, 4);
        lRUCache2.put(4, 22);
        lRUCache2.put(7, 24);
        lRUCache2.put(9, 26);
        lRUCache2.put(13, 28);
        lRUCache2.put(11, 26);
        // (sequence continues...)
    }

}