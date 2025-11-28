import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    HashMap<Integer,Integer> map1Count;
    int[] map2Freq;
    int[]nums1,nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        map2Freq= new int[100001];
        map1Count=new HashMap<>();

        for (int i : nums1) {
            map1Count.put(i,map1Count.getOrDefault(i,0)+1);
        }
        for (int i : nums2) {
            map2Freq[i]++;
        }
    }

    public void add(int index, int val) {
        if(map2Freq[nums2[index]]>0)
         map2Freq[nums2[index]]--;
        nums2[index]+=val;
        map2Freq[nums2[index]]++;
    }

    public int count(int tot) {
        int count=0;
        for (Map.Entry<Integer, Integer> n1KeySet : map1Count.entrySet()) {
            int n1=n1KeySet.getKey();
            int diff=tot-n1;
            int diffExists=diff>=0 && diff<100001?map2Freq[diff]:0;
            count+=diffExists*n1KeySet.getValue();
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};

        FindSumPairs fsp = new FindSumPairs(nums1, nums2);

        System.out.println(fsp.count(7)); // expected 8

        fsp.add(3, 2); // nums2 becomes [1,4,5,4,5,4]

        System.out.println(fsp.count(8)); // expected 2
        System.out.println(fsp.count(4)); // expected 1

        fsp.add(0, 1); // nums2 becomes [2,4,5,4,5,4]
        fsp.add(1, 1); // nums2 becomes [2,5,5,4,5,4]

        System.out.println(fsp.count(7)); // expected 11
    }

}
