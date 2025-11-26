import java.util.*;


class NumberContainers {
    HashMap<Integer,Integer> map;//index-number
    HashMap<Integer, TreeSet<Integer>> treeIndexMap;//number-index(treeset)
    public NumberContainers() {
        map= new HashMap<>();
        treeIndexMap= new HashMap<>();
    }

    public void change(int index, int number) {
        if(treeIndexMap.containsKey(number)){
            treeIndexMap.get(number).add(index);
        }
        else{

            TreeSet<Integer> temp= new TreeSet<>();
            temp.add(index);
            treeIndexMap.put(number,temp);
        }
        if(map.containsKey(index)){
            int num=map.get(index);
            if(num!=number)
                treeIndexMap.get(num).remove(index);
        }
        map.put(index,number);
    }

    public int find(int number) {
        if(treeIndexMap.containsKey(number)){
            if(treeIndexMap.get(number).isEmpty()) return -1;
            return treeIndexMap.get(number).first();
        }
        return -1;
    }
    public static void main(String[] args) {


        // Test Case 2  ------------------------------------------
        NumberContainers nc2 = new NumberContainers();
        nc2.change(1, 10);
        nc2.change(1, 10);
        System.out.println(nc2.find(10)); // Expected: -1
        nc2.change(1, 20);
        System.out.println(nc2.find(10)); // Expected: -1




        // Test Case 3  ------------------------------------------
        NumberContainers nc3 = new NumberContainers();
        nc3.change(100, 1);
        nc3.change(50, 1);
        nc3.change(75, 2);

        System.out.println(nc3.find(1)); // Expected: 50
        System.out.println(nc3.find(2)); // Expected: 75
        System.out.println(nc3.find(3)); // Expected: -1
    }

}
