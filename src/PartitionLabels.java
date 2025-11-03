import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[]lastPos= new int[26];
        int[]firstPos= new int[26];
        Arrays.fill(lastPos,-1);
        Arrays.fill(firstPos,-1);
        char[]cs=s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            lastPos[c-'a']=i;
            if(firstPos[c-'a']==-1)
             firstPos[c-'a']=i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0; // start of current partition
        int maxLast = 0; // farthest last index seen so far

        for (int i = 0; i < s.length(); i++) {
            maxLast = Math.max(maxLast, lastPos[s.charAt(i) - 'a']);
            if (i == maxLast) { // end of one partition
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();

        String s1 = "ababcbacadefegdehijhklij";
        System.out.println(obj.partitionLabels(s1)); // Expected: [9,7,8]

        String s2 = "eccbbbbdec";
        System.out.println(obj.partitionLabels(s2)); // Expected: [10]

        String s3 = "abc";
        System.out.println(obj.partitionLabels(s3)); // Expected: [1,1,1]
    }




}
