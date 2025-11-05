import java.util.*;

public class FindXSumOfAllKLongSubArraysII {



        static Comparator<Pair> cmp = (a, b) -> {
            if (a.freq == b.freq) {
                return a.value - b.value;
            }
            return a.freq - b.freq;
        };

        long currentSum = 0;

        public long[] findXSum(int[] nums, int k, int x) {
            currentSum = 0;
            int n = nums.length;

            Map<Integer, Integer> freqMap = new HashMap<>();
            TreeSet<Pair> topSet = new TreeSet<>(cmp);
            TreeSet<Pair> restSet = new TreeSet<>(cmp);

            // Initialize frequency map
            for (int i = 0; i < k; i++) {
                int num = nums[i];
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Fill initial restSet
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                restSet.add(new Pair(entry.getValue(), entry.getKey()));
            }

            long[] result = new long[n - k + 1];

            balance(restSet,topSet,x);

            // Sliding window
            for (int i = 0; i < n - k + 1; i++) {
                result[i] = currentSum;
                if (i + k >= n) break;

                int outgoing = nums[i];
                int incoming = nums[i + k];

                // Remove outgoing element
                Pair outPair = new Pair(freqMap.get(outgoing), outgoing);

                if (topSet.contains(outPair)) {
                    currentSum -= (long) outPair.freq * outPair.value;
                    topSet.remove(outPair);
                }
                restSet.remove(outPair);

                if (freqMap.get(outgoing) <= 1) {
                    freqMap.remove(outgoing);
                } else {
                    freqMap.put(outgoing, freqMap.get(outgoing) - 1);
                    Pair updatedOut = new Pair(freqMap.get(outgoing), outgoing);

                    if (topSet.size() < x) {
                        topSet.add(updatedOut);
                        currentSum += (long) updatedOut.freq * updatedOut.value;
                    } else {
                        restSet.add(updatedOut);
                    }
                    balance(restSet, topSet, x);
                }

                // Add incoming element
                if (freqMap.containsKey(incoming)) {
                    Pair inPair = new Pair(freqMap.get(incoming), incoming);

                    if (topSet.contains(inPair)) {
                        currentSum -= (long) inPair.freq * inPair.value;
                        topSet.remove(inPair);
                    } else if (restSet.contains(inPair)) {
                        restSet.remove(inPair);
                    }

                    if (topSet.size() < x) {
                        topSet.add(new Pair(inPair.freq + 1, inPair.value));
                        currentSum += (long) (inPair.freq + 1) * inPair.value;
                    } else {
                        restSet.add(new Pair(inPair.freq + 1, inPair.value));
                    }

                    balance(restSet, topSet, x);
                    freqMap.put(incoming, freqMap.getOrDefault(incoming, 0) + 1);
                } else {
                    freqMap.put(incoming, 1);
                    Pair newInPair = new Pair(1, incoming);

                    if (topSet.size() < x) {
                        topSet.add(newInPair);
                        currentSum += (long) newInPair.freq * newInPair.value;
                    } else {
                        restSet.add(newInPair);
                    }

                    balance(restSet, topSet, x);
                }
            }

            return result;
        }

        public void balance(TreeSet<Pair> restSet, TreeSet<Pair> topSet, int x) {
            if (restSet.isEmpty()) return;

            // Fill if topSet has less than x elements
            if (topSet.size() < x) {
                while (topSet.size() < x && !restSet.isEmpty()) {
                    Pair fromRest = restSet.removeLast();
                    currentSum += (long) fromRest.freq * fromRest.value;
                    topSet.add(fromRest);
                }
                return;
            }

            // Swap if restSet’s best > topSet’s worst
            if (cmp.compare(topSet.first(), restSet.last()) < 0) {
                Pair worstTop = topSet.removeFirst();
                Pair bestRest = restSet.removeLast();
                currentSum -= (long) worstTop.freq * worstTop.value;
                currentSum += (long) bestRest.freq * bestRest.value;
                restSet.add(worstTop);
                topSet.add(bestRest);
            }
        }

        static class Pair {
            int freq;
            int value;
            public Pair(int freq, int value) {
                this.freq = freq;
                this.value = value;
            }
        }



    public static void main(String[] args) {
        FindXSumOfAllKLongSubArraysII soln= new FindXSumOfAllKLongSubArraysII();

        System.out.println(Arrays.toString(soln.findXSum(new int[]{4,5,3,5,2,3,6,6,5,4}, 4, 2)));//14,13,11,11,15,17,17
        System.out.println(Arrays.toString(soln.findXSum(new int[]{10,3,8,3}, 3, 2)));
        System.out.println(Arrays.toString(soln.findXSum(new int[]{1,6,5,5}, 2, 1)));
        System.out.println(Arrays.toString(soln.findXSum(new int[]{7,10,8,9,10}, 5, 5)));
        System.out.println(Arrays.toString(soln.findXSum(new int[]{3,8,7,8,7,5}, 2, 2)));
        System.out.println(Arrays.toString(soln.findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));

    }





}
