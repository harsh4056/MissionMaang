import java.util.*;

class RandomizedSet {

    HashMap<Integer, Integer> locationValMap;
    List<Integer> valList;
    Random rand;

    public RandomizedSet() {
        locationValMap = new HashMap<>();
        valList = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (locationValMap.containsKey(val)) {
            return false;
        }
        locationValMap.put(val, valList.size());
        valList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!locationValMap.containsKey(val)) {
            return false;
        }
        int presentIndex = locationValMap.get(val);
        int lastElement = valList.get(valList.size() - 1);

        // Swap
        valList.set(presentIndex, lastElement);
        locationValMap.put(lastElement, presentIndex);

        // Remove
        valList.remove(valList.size() - 1);
        locationValMap.remove(val);

        return true;
    }

    public int getRandom() {
        int randomNumber = rand.nextInt(valList.size());
        return valList.get(randomNumber);
    }
}
