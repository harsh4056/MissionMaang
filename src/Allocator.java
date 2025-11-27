import java.util.Arrays;
import java.util.HashMap;

public class Allocator {
    int[] memory;

    public Allocator(int n) {
        memory= new int[n];
        //Arrays.fill(memory,-1);

    }

    public int allocate(int size, int mID) {
        int avail=getAvail(size);
        int index=-1;
        if(avail!=-1){
            for (int i = avail; i < memory.length && size>0; i++) {
                if(memory[i]==0) {
                    memory[i] = mID;
                    if(index==-1) index=i;
                    size--;
                }

            }
        }
        return index;
    }

    public int freeMemory(int mID) {
        int size=0;
        for (int i = 0; i < memory.length; i++) {
            if(memory[i]==mID) {
                memory[i] = 0;
                size++;
            }

        }
        return size;
    }
    public int getAvail(int size){
        int index=-1;
        int avail=0;
        for (int i = 0; i < memory.length; i++) {
           if(memory[i]==0){
               avail++;
               if(index==-1)index=i;
           }
           else{
               index=-1;
               avail=0;
           }
           if(avail==size){
               return index;
           }
        }
        return -1;
    }
    public static void main(String[] args) {

        Allocator alloc = new Allocator(10);

        System.out.println(alloc.allocate(1, 1));   // Expected: 0
        System.out.println(alloc.allocate(1, 2));   // Expected: 1
        System.out.println(alloc.allocate(1, 3));   // Expected: 2

        System.out.println(alloc.freeMemory(2));    // Expected: 1  (frees index 1)

        System.out.println(alloc.allocate(3, 4));   // Expected: 3  (allocates 3 slots: 3,4,5)

        System.out.println(alloc.allocate(1, 1));   // Expected: 1
        System.out.println(alloc.allocate(1, 1));   // Expected: 6

        System.out.println(alloc.freeMemory(1));    // Expected: 3  (frees indices 0,1,6)

        System.out.println(alloc.allocate(10, 2));  // Expected: -1  (no contiguous block of size 10)

        System.out.println(alloc.freeMemory(7));    // Expected: 0  (not allocated)
    }



}
