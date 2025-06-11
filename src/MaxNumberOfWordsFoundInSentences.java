public class MaxNumberOfWordsFoundInSentences {

    public int mostWordsFound(String[] sentences) {
        int globalMax=Integer.MIN_VALUE;

        for(String sentence:sentences){
            if(sentence.isEmpty()){
                continue;
            }
            int count=0;
            for (int i = 0; i < sentence.length(); i++) {
                if(sentence.charAt(i)==' ')
                    count++;
            }
            globalMax=Math.max(globalMax,count+1);
        }
        return globalMax;
    }
}
