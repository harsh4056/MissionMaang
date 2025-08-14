import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[]arr=s.toCharArray();
        boolean []visited=new boolean[26];
        int[] map= new int[26];
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            map[c-'a']=i;
        }
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if(!visited[c-'a']){
                while(!stack.isEmpty() &&
                        arr[stack.peek()]>c &&
                        map[arr[stack.peek()]-'a']>i){
                    visited[arr[stack.peek()]-'a']=false;
                    stack.pop();
                }
                visited[c-'a']=true;
                stack.push(i);
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty()){
            int index=stack.pop();
            sb.insert(0,arr[index]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();

        // Test case 1
        String s1 = "bbcaac";
        System.out.println(solution.removeDuplicateLetters(s1)); // Expected: "abc"

        // Test case 2
        String s2 = "cbacdcbc";
        System.out.println(solution.removeDuplicateLetters(s2)); // Expected: "acdb"

        // Test case 3
        String s3 = "abacb";
        System.out.println(solution.removeDuplicateLetters(s3)); // Expected: "abc"
    }

}
