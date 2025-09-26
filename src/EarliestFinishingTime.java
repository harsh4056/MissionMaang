public class EarliestFinishingTime {

    public static void main(String[] args) {
        int[] landStartTime = {5};
        int[] landDuration = {3};
        int[] waterStartTime = {1};
        int[] waterDuration = {10};

        int combinedEnd = earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(combinedEnd);
    }

    static int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

                int minLandFinish = Integer.MAX_VALUE;
                for (int i = 0; i < landStartTime.length; i++)
                    minLandFinish = Math.min(minLandFinish, landStartTime[i] + landDuration[i]);

                int minWaterFinish = Integer.MAX_VALUE;
                for (int j = 0; j < waterStartTime.length; j++)
                    minWaterFinish = Math.min(minWaterFinish, waterStartTime[j] + waterDuration[j]);

                int result = Integer.MAX_VALUE;

                // Land -> Water sequence
                for (int j = 0; j < waterStartTime.length; j++) {
                    int finish = waterDuration[j] + Math.max(minLandFinish, waterStartTime[j]);
                    result = Math.min(result, finish);
                }

                // Water -> Land sequence
                for (int i = 0; i < landStartTime.length; i++) {
                    int finish = landDuration[i] + Math.max(minWaterFinish, landStartTime[i]);
                    result = Math.min(result, finish);
                }

                return result;

    }
}
