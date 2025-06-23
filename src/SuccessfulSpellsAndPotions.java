import java.util.Arrays;

public class SuccessfulSpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int left = 0;
            int right = potions.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long) spell * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = potions.length - left;
        }

        return result;
    }

    public static void main(String[] args) {
        SuccessfulSpellsAndPotions solution = new SuccessfulSpellsAndPotions();

        int[] spells1 = {10, 20, 30};
        int[] potions1 = {1, 2, 3, 4, 5};
        long success1 = 100;
        System.out.println(Arrays.toString(solution.successfulPairs(spells1, potions1, success1))); // [0, 1, 2]

        int[] spells2 = {5, 1, 3};
        int[] potions2 = {1, 2, 3, 4};
        long success2 = 4;
        System.out.println(Arrays.toString(solution.successfulPairs(spells2, potions2, success2))); // [4, 1, 3]

        int[] spells3 = {8, 5};
        int[] potions3 = {3, 6, 1, 4};
        long success3 = 24;
        System.out.println(Arrays.toString(solution.successfulPairs(spells3, potions3, success3))); // [3, 1]

        int[] spells4 = {2, 3};
        int[] potions4 = {1, 2, 3, 4};
        long success4 = 6;
        System.out.println(Arrays.toString(solution.successfulPairs(spells4, potions4, success4))); // [2, 3]

        int[] spells5 = {1, 2, 3, 4, 5};
        int[] potions5 = {10};
        long success5 = 10;
        System.out.println(Arrays.toString(solution.successfulPairs(spells5, potions5, success5))); // [1, 1, 1, 1, 1]

        int[] spells6 = {1, 2, 3};
        int[] potions6 = {5, 5, 5};
        long success6 = 20;
        System.out.println(Arrays.toString(solution.successfulPairs(spells6, potions6, success6))); // [0, 0, 0]
    }
}
