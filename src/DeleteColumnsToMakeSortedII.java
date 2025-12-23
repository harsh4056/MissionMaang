import java.util.Arrays;

public class DeleteColumnsToMakeSortedII {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int n = strs.length;
        String [] builder= new String[n];
        Arrays.fill(builder, "");
        for(int i=0;i<m;i++){
            String prev=builder[0]+strs[0].charAt(i);
            boolean full=true;
            for(int j=1;j<n;j++){
                String curr=builder[j]+strs[j].charAt(i);
                if((prev).compareTo(curr)>0){
                    full=false;
                    break;
                }
                else{
                    prev=curr;
                }
            }
            if(full){
                for(int j=0;j<n;j++){
                    builder[j]=builder[j]+strs[j].charAt(i);
                }
            }
        }

        return strs[0].length()-builder[0].length();
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSortedII soln= new DeleteColumnsToMakeSortedII();
        System.out.println(soln.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        System.out.println(soln.minDeletionSize(new String[]{"xga","xfb","yfa"}));
    }
}
