public class LongestCommonSubstring {
    String answer="";
    int max=0;
    public String longestCommonSubstring(String string1,String string2){

        String ans= findLongest(string1.toCharArray(),string2.toCharArray(),string1.length()-1,string2.length()-1,"");
        return ans;
    }

    public String findLongest(char[]str1,char[]str2,int index1,int index2,String string){
        if(index2<0 ||index1<0){
            return "";
        }
        String temp="";
        if(str1[index1]==str2[index2]){
            string=str1[index1]+string;
            temp= findLongest(str1,str2,index1-1,index2-1,string);

        }


            String s1=findLongest(str1,str2,index1,index2-1,"");
            String s2=findLongest(str1,str2,index1-1,index2,"");
            if(s1.length()>s2.length()){
                temp=s1;
            }
            else{
                temp=s2;
            }


        if(temp.length()>string.length()){
            return temp;
        }
        return string;


    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs= new LongestCommonSubstring();
        System.out.println(lcs.longestCommonSubstring("yxxzzxxxx","yzyzxxyxxz"));
    }



}
