public class FindTheIndexOfTheFirstOccurrenceInAString {


    public int strStr(String haystack, String needle) {
        Trie trie= new Trie();
        trie.add(needle);
        for(int i=0;i<haystack.length() && i+needle.length()<=haystack.length();i++){
            boolean found=trie.search(haystack,i,i+needle.length());
            if(found) return i;
        }
        return -1;
    }


    class Trie{


        Trie[]tries;
        boolean present=false;
        Trie(){
            tries=new Trie[26];
        }
        public void add(String s){
            char[]cs= s.toCharArray();
            Trie curr= this;
            for(int i=0;i<cs.length;i++){
                if(curr.tries[cs[i]-'a']==null){
                    curr.tries[cs[i]-'a']= new Trie();
                }
                curr= curr.tries[cs[i]-'a'];
            }
            curr.present=true;
        }
        public boolean search(String s,int l,int r){
            char[]cs= s.toCharArray();
            Trie curr= this;
            for(int i=l;i<r;i++){
                if(curr.tries[cs[i]-'a']==null){
                    return false;
                }
                curr= curr.tries[cs[i]-'a'];
            }
            return curr.present;
        }

    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString soln= new FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(soln.strStr("a","a"));
    }
}
