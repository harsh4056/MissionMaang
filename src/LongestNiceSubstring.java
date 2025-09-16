public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        //int[] lowerFreq = new int[26];
        //int[] upperFreq = new int[26];
        char[] arr = s.toCharArray();
        int n = arr.length;
        int max=0;
        String answer = "";
        for (int i = 0; i < n; i++) {
            boolean[] lowerFreq = new boolean[26];
            boolean[] upperFreq = new boolean[26];
            char start = arr[i];
            if (start <= 'Z')
                upperFreq[start - 'A'] = true;
            else
                lowerFreq[start - 'a'] = true;
            for (int j = i + 1; j < n; j++) {
                char c=arr[j];
                if (c <= 'Z')
                    upperFreq[c - 'A'] = true;
                else
                    lowerFreq[c - 'a'] = true;
                boolean isNice = true;
                for (int k = 0; k < 26; k++) {
                    if (lowerFreq[k] != upperFreq[k]) {
                        isNice=false;
                        break;
                    }
                }
                if(isNice){
                    int len=j-i+1;
                    if(len>max){
                        max=len;
                        answer=new String(arr,i,len);
                    }
                }
            }
        }
        return answer;

    }


    public static void main(String[] args) {
        LongestNiceSubstring sol= new LongestNiceSubstring();
        System.out.println(sol.longestNiceSubstring("YazaAay"));
    }
}
