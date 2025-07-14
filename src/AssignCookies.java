import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int children=0;
        int p1=0;
        int p2=0;
        while(p2<s.length && p1<g.length){
            if(s[p2]>=g[p1]){
                p1++;
                p2++;
                children++;
            }
            else
                p2++;

        }
        return children;


    }
    public static void main(String[] args) {
        AssignCookies solution = new AssignCookies();

        System.out.println(solution.findContentChildren(new int[]{1,2,3}, new int[]{1,1})); // Expected: 1
        System.out.println(solution.findContentChildren(new int[]{1,2}, new int[]{1,2,3})); // Expected: 2
        System.out.println(solution.findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8})); // Expected: 2
    }


}
