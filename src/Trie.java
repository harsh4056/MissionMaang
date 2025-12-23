class Trie {
    Trie[] tries;
    boolean exist=false;
    public Trie() {
        tries= new Trie[26];
    }

    public void insert(String word) {
        char[]cword= word.toCharArray();
        Trie curr= this;
        for(char c:cword){
            if(curr.tries[c-'a']==null){
                curr.tries[c-'a']= new Trie();
            }

            curr=curr.tries[c-'a'];
        }
        curr.exist=true;
    }

    public boolean search(String word) {
        char[]cword= word.toCharArray();
        Trie curr= this;
        for(char c:cword){
            if(curr.tries[c-'a']==null){
                return false;
            }
            curr=curr.tries[c-'a'];
        }
        return curr.exist;

    }

    public boolean startsWith(String prefix) {
        char[]cword= prefix.toCharArray();
        Trie curr= this;
        for(char c:cword){
            if(curr.tries[c-'a']==null){
                return false;
            }
            curr=curr.tries[c-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hotdog");
        System.out.println(trie.startsWith("dog"));
        System.out.println(trie.search("hotdog"));
    }
}