public class TakingMaximumEnergyFromTheMysticDungeonAttempted {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] arr = new int[k];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int ci = i - k >= 0 ? i - k : i;
            if (ci != i) {
                arr[i%k] = Math.max(energy[i], energy[i] + arr[ci%k]);
            } else {
                arr[i%k] = energy[i];

            }
            if (i >= n - k) {
                max = Math.max(max, arr[i%k]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        TakingMaximumEnergyFromTheMysticDungeonAttempted sol = new TakingMaximumEnergyFromTheMysticDungeonAttempted();

        int[] energy1 = {5, 2, -10, -5, 1};
        int k1 = 3;
        System.out.println(sol.maximumEnergy(energy1, k1)); // Expected output: 3

        int[] energy2 = {-2, -3, -1};
        int k2 = 2;
        System.out.println(sol.maximumEnergy(energy2, k2)); // Expected output: -1

        int[] energy3 = {2, 10, -5, 4, -3, 2};
        int k3 = 2;
        System.out.println(sol.maximumEnergy(energy3, k3)); // Expected output: 16
    }

}
