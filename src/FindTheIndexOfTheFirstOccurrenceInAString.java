public class FindTheIndexOfTheFirstOccurrenceInAString {


    public int strStr(String haystack, String needle) {
        char[] h= haystack.toCharArray();
        char[] n= needle.toCharArray();


        int k=0;
        for(int i=0;i<h.length;i++){
            if(h[i]==n[k]){
                k++;
                if(k==n.length){
                    return i-n.length+1;
                }
            }
            else{
                k=0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString soln= new FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(soln.strStr("sadbutsad","sad"));
    }
}
