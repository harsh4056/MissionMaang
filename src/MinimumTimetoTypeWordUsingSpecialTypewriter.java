public class MinimumTimetoTypeWordUsingSpecialTypewriter {

    public int minTimeToType(String word) {
        int ops=0;
        char[]cword=word.toCharArray();
        int position=0;
        for(char c:cword){
            int curr=c-'a';
            int clockwise=(((curr-position)%26)+26)%26;
            int counterClockwise=(((position-curr)%26)+26)%26;
            ops+=Math.min(clockwise,counterClockwise)+1;
            position=c-'a';
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumTimetoTypeWordUsingSpecialTypewriter soln= new MinimumTimetoTypeWordUsingSpecialTypewriter();
        System.out.println(soln.minTimeToType("abc"));
        System.out.println(soln.minTimeToType("bza"));
        System.out.println(soln.minTimeToType("zjpc"));
    }
}
