package prefixtree;

public class Trie {
    Boolean present= false;

    Trie[] tries;
        Trie root;


    public Trie(Boolean present) {
        this.present = present;
        tries= new Trie[26];

    }


    public Trie() {
        root=this;
        tries= new Trie[26];
    }

    public void insert(String word) {
        Trie current=root;
        for(char c:word.toCharArray()){
            if(current.tries[c-'a']==null)
             current.tries[c-'a']= new Trie(false);
            current= current.tries[c-'a'];
        }
        current.present=true;

    }

    public boolean search(String word) {
        Trie current=root;
        for(char c:word.toCharArray()){
            if(current.tries[c-'a']!=null) {
                current = current.tries[c - 'a'];
            }
            else {
                return false;
            }

        }
        return current.present;

    }

    public boolean startsWith(String prefix) {
        Trie current=root;
        for(char c:prefix.toCharArray()){
            if(current.tries[c-'a']!=null) {
                current = current.tries[c - 'a'];
            }
            else {
                return false;
            }

        }
        return true;
    }




}
