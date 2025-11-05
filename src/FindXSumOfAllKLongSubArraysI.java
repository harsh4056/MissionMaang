import java.util.*;

public class FindXSumOfAllKLongSubArraysI {

    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int []answer= new int[n-k+1];
        FrequencyTracker frequencyTracker= new FrequencyTracker();
        for (int i = 0; i < k; i++) {
            frequencyTracker.increment(nums[i]);
        }

        List<Integer> topx=frequencyTracker.getTopX(x);
        for (Integer integer : topx) {
            answer[0]+=integer*frequencyTracker.freqMap.get(integer);
        }

        for (int i = 1; i < n - k + 1; i++) {
            frequencyTracker.decrement(nums[i-1]);
            frequencyTracker.increment(nums[i+k-1]);
            for (Integer integer : frequencyTracker.getTopX(x)) {
                answer[i]+=integer*frequencyTracker.freqMap.get(integer);
            }
        }


        return answer;

    }

    public static void main(String[] args) {
        FindXSumOfAllKLongSubArraysI findXSumOfAllKLongSubArraysI= new FindXSumOfAllKLongSubArraysI();
        System.out.println(Arrays.toString(findXSumOfAllKLongSubArraysI.findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
    }


    public static class FrequencyTracker {
        private final Map<Integer, Integer> freqMap;                  // num -> frequency
        private final TreeMap<Integer, TreeSet<Integer>> treeMap;     // frequency -> elements (sorted desc)

        public FrequencyTracker() {
            freqMap = new HashMap<>();
            // Higher frequency first → so we’ll use descending order when iterating
            treeMap = new TreeMap<>();
        }

        // Increment frequency
        public void increment(int num) {
            int oldFreq = freqMap.getOrDefault(num, 0);
            int newFreq = oldFreq + 1;
            freqMap.put(num, newFreq);

            // remove from old frequency bucket
            if (oldFreq > 0) {
                TreeSet<Integer> oldSet = treeMap.get(oldFreq);
                oldSet.remove(num);
                if (oldSet.isEmpty()) treeMap.remove(oldFreq);
            }

            // add to new frequency bucket (TreeSet sorts by value descending)
            treeMap.computeIfAbsent(newFreq, k -> new TreeSet<>(Comparator.reverseOrder())).add(num);
        }

        // Decrement frequency
        public void decrement(int num) {
            if (!freqMap.containsKey(num)) return;

            int oldFreq = freqMap.get(num);
            int newFreq = oldFreq - 1;

            // remove from old frequency bucket
            TreeSet<Integer> oldSet = treeMap.get(oldFreq);
            oldSet.remove(num);
            if (oldSet.isEmpty()) treeMap.remove(oldFreq);

            // update new frequency
            if (newFreq == 0) {
                freqMap.remove(num);
            } else {
                freqMap.put(num, newFreq);
                treeMap.computeIfAbsent(newFreq, k -> new TreeSet<>(Comparator.reverseOrder())).add(num);
            }
        }

        // Get top X elements (sorted by frequency desc, then value desc)
        public List<Integer> getTopX(int x) {
            List<Integer> result = new ArrayList<>();
            for (int freq : treeMap.descendingKeySet()) {  // highest freq first
                for (int num : treeMap.get(freq)) {        // highest value first
                    result.add(num);
                    if (result.size() == x) return result;
                }
            }
            return result;
        }


    }

}
