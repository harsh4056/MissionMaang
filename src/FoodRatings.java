import java.util.*;

class FoodRatings {
    HashMap<String,MaxHeap> map;
    HashMap<String,String> fToCMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map= new HashMap<>();
        fToCMap= new HashMap<>();
        for (int i = 0; i < ratings.length; i++) {
            String cuisine=cuisines[i];
            String food=foods[i];
            int rating=ratings[i];
            fToCMap.put(food,cuisine);
            if(map.containsKey(cuisine)){
              MaxHeap maxHeap=  map.get(cuisine);
              maxHeap.insert(food,rating);
            }
            else{
                MaxHeap maxHeap=  new MaxHeap();
                maxHeap.insert(food,rating);
                map.put(cuisine,maxHeap);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine=fToCMap.get(food);
        MaxHeap maxHeap=map.get(cuisine);
        maxHeap.updateKey(food,newRating);
    }

    public String highestRated(String cuisine) {
        MaxHeap.Node node=map.get(cuisine).peekMax();
        return node.key;
    }




    public class MaxHeap {
        public static class Node {
            String key;
            int value;

            Node(String key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "(" + key + "," + value + ")";
            }
        }

        private final List<Node> heap;
        private final Map<String, Integer> indexMap;

        public MaxHeap() {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
        }

        private void swap(int i, int j) {
            Node ni = heap.get(i);
            Node nj = heap.get(j);

            heap.set(i, nj);
            heap.set(j, ni);

            indexMap.put(ni.key, j);
            indexMap.put(nj.key, i);
        }

        /** Comparison: value first (higher wins), then lexicographically smaller key wins */
        private boolean greater(Node a, Node b) {
            if (a.value != b.value) {
                return a.value > b.value;
            }
            return a.key.compareTo(b.key) < 0; // smaller lexicographic string is "greater"
        }

        private void bubbleUp(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (greater(heap.get(i), heap.get(parent))) {
                    swap(i, parent);
                    i = parent;
                } else break;
            }
        }

        private void heapifyDown(int i) {
            int n = heap.size();
            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int largest = i;

                if (left < n && greater(heap.get(left), heap.get(largest))) {
                    largest = left;
                }
                if (right < n && greater(heap.get(right), heap.get(largest))) {
                    largest = right;
                }

                if (largest != i) {
                    swap(i, largest);
                    i = largest;
                } else break;
            }
        }

        public void insert(String key, int value) {
            if (indexMap.containsKey(key)) {
                throw new IllegalArgumentException("Key already exists: " + key);
            }
            Node node = new Node(key, value);
            heap.add(node);
            int idx = heap.size() - 1;
            indexMap.put(key, idx);
            bubbleUp(idx);
        }

        public Node peekMax() {
            if (heap.isEmpty()) return null;
            return heap.get(0);
        }

        public Node extractMax() {
            if (heap.isEmpty()) return null;
            Node root = heap.get(0);
            Node last = heap.remove(heap.size() - 1);
            indexMap.remove(root.key);

            if (!heap.isEmpty()) {
                heap.set(0, last);
                indexMap.put(last.key, 0);
                heapifyDown(0);
            }
            return root;
        }

        public void updateKey(String key, int newValue) {
            if (!indexMap.containsKey(key)) {
                throw new NoSuchElementException("Key not found: " + key);
            }
            int idx = indexMap.get(key);
            int oldValue = heap.get(idx).value;
            heap.get(idx).value = newValue;

            if (newValue > oldValue) {
                bubbleUp(idx);
            } else if (newValue < oldValue) {
                heapifyDown(idx);
            } else {
                // same value, lexicographic order might be affected
                bubbleUp(idx);
                heapifyDown(idx);
            }
        }

        public void printHeap() {
            for (Node node : heap) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        // Example usage

    }

    public static void main(String[] args) {
        String[] foods = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisines = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings = {9,12,8,15,14,7};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);

        // Test case 1
        System.out.println(foodRatings.highestRated("korean")); // Expected: kimchi
        System.out.println(foodRatings.highestRated("japanese")); // Expected: ramen

        // Test case 2
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese")); // Expected: sushi

        // Test case 3
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese")); // Expected: ramen (since ramen and sushi tie, but ramen comes lexicographically smaller if implemented that way — your heap currently ignores lexicographic order)
    }



}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */