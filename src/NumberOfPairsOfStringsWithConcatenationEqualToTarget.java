import java.util.HashMap;

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {


    public int numOfPairs(String[] nums, String target) {

        HashMap<String,Integer> map = new HashMap<>();
        for(String num:nums){
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
        }
        return find(0,map,target);
            //return count;
    }

    public int find(int index,HashMap<String,Integer> map,String target){
        if(index==target.length()){
            return 1;
        }
        int value=0;
        for(int i=index+1;i<=target.length();i++){
            String s=target.substring(index,i);

            if(map.containsKey(s) && map.get(s)>0){
                int freq= map.get(s);
                map.put(s,map.get(s)-1);
                value+=freq*find(i,map,target);
                map.put(s,map.get(s)+1);


            }
        }

        return value;
    }

    public static void main(String[] args) {
        NumberOfPairsOfStringsWithConcatenationEqualToTarget obj = new NumberOfPairsOfStringsWithConcatenationEqualToTarget();



        String[] nums = {"7672198","767","221","698566842","2198903679","7672198","2198903679",
                "76721989036","973","767219890367","2051569","903679","605513",
                "7672","9","5","79","50","5657214709160","673123241121","3679",
                "672198903679","903679","3651502","56","27","767219890","198903679","7","767"};
        String target = "7672198903679";

        System.out.println(obj.numOfPairs(nums, target)); // Expected: 13

        String[] nums3 = {"777","7","77","77"};
        String target3 = "7777";
        System.out.println(obj.numOfPairs(nums3, target3)); // Expected: 4


        String[] nums2 = {"123","4","12","34"};
        String target2 = "1234";
        System.out.println(obj.numOfPairs(nums2, target2)); // Expected: 2


        String[] nums1 = {"1","1","1"};
        String target1 = "11";
        System.out.println(obj.numOfPairs(nums1, target1)); // Expected: 6




    }


}
