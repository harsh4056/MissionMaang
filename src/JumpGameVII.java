public class JumpGameVII {

    public boolean canReach(String s, int minJump, int maxJump) {
        return findIfCanReach(s,minJump,maxJump,0);
    }
    public boolean findIfCanReach(String s,int minJump,int maxJump,int index){
        if(index>=s.length() || s.charAt(index)=='1'){
            return false;
        }
        if(index==s.length()-1){
            return true;
        }
        boolean canReach=false;
        for(int i=(index+maxJump);i>=index+minJump;i--){
            if(i>s.length()-1)
                continue;
            canReach = findIfCanReach(s, minJump, maxJump, i);
            if(canReach)
                return true;
        }
        return canReach;
    }


    public static void main(String[] args) {
        JumpGameVII solution = new JumpGameVII();

        String s1 = "011010";
        System.out.println(solution.canReach(s1, 2, 3)); // true

        String s2 = "01101110";
        System.out.println(solution.canReach(s2, 2, 3)); // false

        String s3 = "0000000000";
        System.out.println(solution.canReach(s3, 2, 5)); // true
    }

}
