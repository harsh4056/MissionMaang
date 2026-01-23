import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[]last= new int[26];
        char[]cs= s.toCharArray();
        for(int i=cs.length-1;i>=0;i--){
            last[cs[i]-'a']=Math.max(i,last[cs[i]-'a']);
        }
        int l=0;
        int count =0;
        List<Integer> list= new ArrayList<>();

        for (int i = 0; i < cs.length; i++) {
            count++;
            char c = cs[i];
            l=Math.max(l,last[c-'a']);
            if(i==l){
                list.add(count);
                count=0;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();

        String s2 = "eccbbbbdec";
        System.out.println(obj.partitionLabels(s2)); // Expected: [10]

        String s1 = "ababcbacadefegdehijhklij";
        System.out.println(obj.partitionLabels(s1)); // Expected: [9,7,8]



        String s3 = "abc";
        System.out.println(obj.partitionLabels(s3)); // Expected: [1,1,1]
    }




}
