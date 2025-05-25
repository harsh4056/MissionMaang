import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GeneMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> pairQueue= new LinkedList<>();
        HashSet <String> visited= new HashSet<>();
        HashSet <String> bankSet = new HashSet<>(Arrays.asList(bank));
        pairQueue.offer(new Pair(startGene,0));
        while (!pairQueue.isEmpty()){

            Pair current = pairQueue.poll();
            String gene = current.gene;
            int mutations = current.mutations;

            if (gene.equals(endGene)) {
                return mutations;
            }

            char[] chars = new char[] {'A', 'C', 'G', 'T'};

            for (int i = 0; i < gene.length(); i++) {
                char[] geneArr = gene.toCharArray();
                for (char c : chars) {
                    if (geneArr[i] == c) continue;
                    geneArr[i] = c;
                    String mutated = new String(geneArr);
                    if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                        visited.add(mutated);
                        pairQueue.offer(new Pair(mutated, mutations + 1));
                    }
                }
            }


        }

        return -1;
    }


    class  Pair{
        String gene;
        int mutations;

        public Pair(String gene, int mutations) {
            this.gene = gene;
            this.mutations = mutations;
        }
    }

}
