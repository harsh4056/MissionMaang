package designaddsearchwordsdatastructure;

import prefixtree.Trie;

class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie=new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        StringBuilder stringBuilder= new StringBuilder(word);
        return find(stringBuilder,trie);
    }
    boolean find(StringBuilder word,Trie root){
        if (root != null && root.present && word.length() == 0)
            return true;
        if (root == null)
            return false;

        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (current.tries[j] != null) {
                        StringBuilder tempWord = new StringBuilder(word.substring(i + 1));
                        if (find(tempWord, current.tries[j]))
                            return true;
                    }
                }
                return false;
            } else {
                current = current.tries[c - 'a'];
                if (current == null)
                    return false;
            }
        }

        return current != null && current.present;


    }

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

         void insert(String word) {
            Trie current=root;
            for(char c:word.toCharArray()){
                if(current.tries[c-'a']==null)
                    current.tries[c-'a']= new Trie(false);
                current= current.tries[c-'a'];
            }
            current.present=true;

        }


    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search("b.s"));
    }

}