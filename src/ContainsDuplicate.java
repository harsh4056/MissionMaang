public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        final int SIZE = 131071; // Larger prime size for bigger datasets
        int[] table = new int[SIZE];
        boolean[] used = new boolean[SIZE];

        for (int num : nums) {
            int i = 0;
            int h = (num % SIZE + SIZE) % SIZE;
            while (used[h]) {
                if (table[h] == num) return true;
                i++;
                h = (h + i * i) % SIZE; // quadratic probing
            }
            table[h] = num;
            used[h] = true;
        }
        return false;
    }

}
