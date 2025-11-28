import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class RangeFreqQuery {
    HashMap<Integer, TreeMap<Integer,Integer>> hashMap;
    public RangeFreqQuery(int[] arr) {
        hashMap= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            TreeMap<Integer,Integer> treeMap;
            if(hashMap.containsKey(num)){
                treeMap=hashMap.get(num);
                Map.Entry<Integer,Integer> entry=treeMap.lowerEntry(i);
                treeMap.put(i,entry.getValue()+1);
            }
            else{
                treeMap=new TreeMap<>();
                treeMap.put(i,1);
                hashMap.put(num,treeMap);
            }
        }
    }

    public int query(int left, int right, int value) {
            if(!hashMap.containsKey(value)) return 0;
            TreeMap<Integer,Integer>map= hashMap.get(value);
            return countInRange(map,left,right);
    }
    public int countInRange(TreeMap<Integer,Integer> map,int L, int R) {
        Integer right = map.floorKey(R);
        if (right == null) return 0;

        Integer left = map.lowerKey(L);
        int rightVal = map.get(right);
        int leftVal = (left == null ? 0 : map.get(left));

        return rightVal - leftVal;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 5, 4, 5, 8, 6, 2, 3};
        RangeFreqQuery rfq = new RangeFreqQuery(arr);

        System.out.println(rfq.query(0, 3, 5)); // expected 1
        System.out.println(rfq.query(5, 6, 2)); // expected 0
        System.out.println(rfq.query(6, 8, 4)); // expected 0
        System.out.println(rfq.query(2, 8, 3)); // expected 0
        System.out.println(rfq.query(4, 5, 1)); // expected 0
        System.out.println(rfq.query(2, 4, 2)); // expected 1
    }

}

