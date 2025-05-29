import java.util.*;

public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> exploreSet= new HashSet<>();
        HashSet<String> addSet= new HashSet<>();
        int n=s.length()-9;
        for (int i = 0; i < n; i++) {
            String t= s.substring(i,i+10);
            if(exploreSet.contains(t)){

                addSet.add(t);
            }
            else{
                exploreSet.add(t);

            }
        }
        return new ArrayList<>(addSet);

    }


    public List<String> findRepeatedDnaSequences2(String s) {

        Map<Character,Integer> bitMap= new HashMap<>();
        bitMap.put('A',0b00);
        bitMap.put('C',0b01);
        bitMap.put('G',0b10);
        bitMap.put('T',0b11);

        int val=0;

        int bitmask = (1 << 20) - 1;

        for (int i = 0; i < 10; i++) {
            val = ((val << 2) & bitmask) | bitMap.get(s.charAt(i));
        }


        Set<Integer> seen = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        List<String> result = new ArrayList<>();
        seen.add(val);


        for (int i = 10; i < s.length(); i++) {
            val = ((val << 2) & bitmask) | bitMap.get(s.charAt(i));

            if (seen.contains(val)) {
                if (!added.contains(val)) {
                    result.add(s.substring(i - 9, i + 1));
                    added.add(val);
                }
            } else {
                seen.add(val);
            }
        }

        return result;



    }

    public static void main(String[] args) {
        RepeatedDNASequence rds = new RepeatedDNASequence();


        // Test Case 2
        String input2 = "AAAAAAAAAAA";
        printResult(rds.findRepeatedDnaSequences(input2));


    }

    public static void printResult(List<String> result) {
        for (String str : result) {
            System.out.println(str);
        }
        System.out.println("---");
    }

}
