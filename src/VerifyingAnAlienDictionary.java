public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[]pos= new int[26];
        char[]corder= order.toCharArray();

        for(int i=0;i<corder.length;i++){
            char c=corder[i];
            pos[c-'a']=i;
        }
        String prev=words[0];
        for(int i=1;i< words.length;i++){
            int len=Math.max(prev.length(),words[i].length());
            for(int j=0;j<len;j++){
                int f=j<prev.length()? pos[prev.charAt(j)-'a']:-1;
                int s=j<words[i].length()?pos[words[i].charAt(j)-'a']:-1;
                if(f<s) break;
                if(f==s){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
