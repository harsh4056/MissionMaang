public class RemoveStarsFromString {

    public String removeStars(String s) {

        char[] arr= s.toCharArray();
        int idx=0;
        for (int i = 0; i < arr.length; i++) {
           if(arr[i]=='*'){
               idx--;
               continue;
           }
           arr[idx++]=arr[i];
        }
        return  String.valueOf(arr,0,idx);
    }

    public static void main(String[] args) {
        RemoveStarsFromString obj = new RemoveStarsFromString();

        System.out.println(obj.removeStars("leet**cod*e")); // Expected: "lecoe"
        System.out.println(obj.removeStars("erase*****")); // Expected: ""
        System.out.println(obj.removeStars("ab**c")); // Expected: "c"
    }

}
