import java.util.*;


class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map= new HashMap<>();
        list= new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int pos=map.get(val);
            list.remove(pos);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomIndex=rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(0);
        obj.insert(1);
        obj.remove(0);
        obj.insert(2);
        obj.remove(1);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
