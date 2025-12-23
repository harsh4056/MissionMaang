public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        int m=strs[0].length();
        int n=strs.length;
        int ans=0;
        for(int i=0;i<m;i++){
            char prev=strs[0].charAt(i);
            for(int j=1;j<n;j++){
                if(strs[j].charAt(i)>=prev){
                    prev=strs[j].charAt(i);
                }
                else{
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted soln= new DeleteColumnsToMakeSorted();
        System.out.println(soln.minDeletionSize(new String[]{"a","b"}));
    }
}
