import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        char[]cs= s.toCharArray();
        int[] pos= new int[26];
        for(int i=cs.length-1;i>=0;i--){
            pos[cs[i]-'a']=Math.max(pos[cs[i]-'a'],i);
        }
        int lastIndex=0;
        int last=0;
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<cs.length;i++){
            last=Math.max(last,pos[cs[i]-'a']);
            if(i==last){
                list.add(last-lastIndex+1);
                lastIndex=lastIndex+list.getLast();
            }

        }
        return list;
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
