package designaddsearchwordsdatastructure;

import prefixtree.Trie;

class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie= new Trie();
    }

    public void addWord(String word) {
        Trie curr= trie;
        char[] cword= word.toCharArray();
        for(char c:cword){
            if(curr.tries[c-'a']==null){
                curr.tries[c-'a']= new Trie();
            }
            curr=curr.tries[c-'a'];
        }
        curr.exists=true;
    }

    public boolean search(String word) {
        return   searchTrie(word.toCharArray(),0,trie);
    }
    public boolean searchTrie(char[] word,int index,Trie root){
        if(index==word.length){
            return root.exists;
        }
        if(word[index]=='.'){
            for(Trie t:root.tries){
                boolean ans=false;
                if(t!=null){
                    ans= searchTrie(word,index+1,t);
                }
                if(ans) return true;
            }
        }
        else{
            if(root.tries[word[index]-'a']!=null){
                return searchTrie(word,index+1,root.tries[word[index]-'a']);
            }
            else{
                return false;
            }

        }
        return false;

    }


    class Trie{
        Trie[] tries;
        boolean exists;
        Trie(){
            tries= new Trie[26];
            exists=false;
        }

    }



    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        // ["WordDictionary","addWord","addWord","addWord","addWord","search","search",
        //  "addWord","search","search","search","search","search","search"]

        // Expected:
        // [null,null,null,null,null,false,false,null,true,true,false,false,true,false]

        wordDictionary.addWord("at");      // null
        wordDictionary.addWord("and");     // null
        wordDictionary.addWord("an");      // null
        wordDictionary.addWord("add");     // null

        System.out.println(wordDictionary.search("a"));    // false
        System.out.println(wordDictionary.search(".at"));  // false

        wordDictionary.addWord("bat");     // null

        System.out.println(wordDictionary.search(".at"));  // true
        System.out.println(wordDictionary.search("an."));  // true
        System.out.println(wordDictionary.search("a.d.")); // false
        System.out.println(wordDictionary.search("b."));   // false
        System.out.println(wordDictionary.search("a.d"));  // true
        System.out.println(wordDictionary.search("."));    // false
    }


}