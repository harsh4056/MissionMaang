public class GuessTheNumber {


    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */


        public int guessNumber(int n) {
            int left=0;
            int right=n;
            int mid=0;
            while(true){
                mid=left+(right-left)/2;
                int result=guess(mid);

                if(result==1){
                    left=mid+1;
                }
                else if(result==-1){
                    right=mid-1;
                }
                else {
                    break;
                }

            }
            return mid;
        }
        int pick=10;
        public int guess(int n){
            if(n==pick){
                return 0;
            }
            else if(n<pick){
                return 1;
            }
            else{
                return -1;
            }
        }

    public static void main(String[] args) {
        GuessTheNumber guessTheNumber= new GuessTheNumber();
        System.out.println(guessTheNumber.guessNumber(10));
    }
}
