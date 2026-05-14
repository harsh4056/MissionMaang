public class TuUpperCase {
    public static void main(String[] args) {
        String name="rohit";
        char[] cname= name.toCharArray();
        /*for (int i = 0; i < cname.length; i++) {

                cname[i]= (char) (cname[i] -('a'-'A'));

        }*/

        /*name=new String(cname);
        for (int i = cname.length-1; i >=0; i--) {
            System.out.print(cname[i]);
        }*/

        int i=0;
        int j=cname.length-1;

        /*while(i<=j){
            if(cname[i]==cname[j]){
                i++;
                j--;
            }
            else{
                System.out.println(false);

            }
        }*/
        System.out.println(true);

        //frequency count
        int[]frequencyCount= new int[26];
        for(int k=0;k<cname.length;k++){
            int charAtK= cname[k]-'a';
            frequencyCount[charAtK]++;
        }

        for(int k=0;k<26;k++){
            System.out.println((char)(k+'a')+"->"+frequencyCount[k]);
        }



        /*for(char c='a';c<='z';c++){
            System.out.print(c+" ");
        }*/


    }



}
