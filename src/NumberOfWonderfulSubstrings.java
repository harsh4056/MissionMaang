public class NumberOfWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        char[]cs=word.toCharArray();
        int n=cs.length;
        int count=0;
        for (int i = 0; i < n; i++) {
            int[] freq= new int[10];

            for (int j = i; j < n; j++) {
                int c = cs[j]-'a';
                freq[c]++;
                int odd=0;
                for(int k=0;k<10;k++){
                    if(freq[k]%2==1){
                        odd++;
                    }
                }
                if(odd<2){
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfWonderfulSubstrings soln= new NumberOfWonderfulSubstrings();
        System.out.println(soln.wonderfulSubstrings("aabb"));
    }
}
