import java.util.*;

public class LadderLength {


        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            HashSet<String> set= new HashSet<>(wordList);


            Queue<Pair> queue= new ArrayDeque<>();
            queue.offer(new Pair(beginWord,1));

            while(!queue.isEmpty()){
                Pair currentPair= queue.poll();
                char[] current= currentPair.word.toCharArray();
                int level=currentPair.level;
                for(int i=0;i<current.length;i++){
                    char t=current[i];
                    for(char c='a';c<='z';c++){
                        current[i]=c;
                        String candidate=new String(current,0,current.length);

                        if(set.contains(candidate)){
                            if(candidate.equals(endWord)){
                                return level+1;
                            }
                            queue.offer(new Pair(candidate,level+1));
                            set.remove(candidate);
                        }
                    }
                    current[i]=t;
                }
            }
            return 0;

        }
        class  Pair{
            String word;
            int level=0;
            Pair(String w,int l){
                word=w;
                level=l;
            }
        }

    public static void main(String[] args) {
        LadderLength solution = new LadderLength();

        // Test case 1
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(solution.ladderLength("hit", "cog", wordList1));
        // Expected: 5 (hit -> hot -> dot -> dog -> cog)

        // Test case 2
        List<String> wordList2 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(solution.ladderLength("hit", "cog", wordList2));
        // Expected: 0 (cog not in word list)

        // Test case 3
        List<String> wordList3 = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(solution.ladderLength("hit", "hot", wordList3));
        // Expected: 2 (hit -> hot)
    }


}
