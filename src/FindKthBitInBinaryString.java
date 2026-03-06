public class FindKthBitInBinaryString {


        public char findKthBit(int n, int k) {
            StringBuilder sb= new StringBuilder();
            sb.append('0');
            solve(n,k,sb);
            return sb.charAt(k-1);
        }
        public void solve(int n,int k,StringBuilder sb){
            if(sb.length()>k || n==0){
                return ;
            }
            StringBuilder temp= new StringBuilder(sb);
            temp.reverse();
            sb.append('1');
            for (int i = 0; i < temp.length(); i++) {
                char c=temp.charAt(i);
                c=(char)(1-(c-'0')+'0');
                sb.append(c);
            }
            solve(n-1,k,sb);
        }

    public static void main(String[] args) {
        FindKthBitInBinaryString soln= new FindKthBitInBinaryString();
        System.out.println(soln.findKthBit(3,1));
    }

}
