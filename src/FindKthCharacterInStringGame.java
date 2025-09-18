public class FindKthCharacterInStringGame {
    public char kthCharacter(int k) {
        int start=1<<9;
        while(start>k){
            start=start>>1;
        }
        int count=0;
        while(k>1){
            k=k-start;
            start=start>>1;
            count++;
        }
        return (char) (count+'a');

    }

    public static void main(String[] args) {
        FindKthCharacterInStringGame soln=new FindKthCharacterInStringGame();
        System.out.println(soln.kthCharacter(499));
    }
}
