package drils.binarysearch;

public class BinarySearchGeneral {
    public int binarySearch(int k){
        int low=1;
        int high=10;
        while(low<high){
            int mid=low+(high-low)/2;


            if(mid<k){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        BinarySearchGeneral binarySearchGeneral= new BinarySearchGeneral();
        binarySearchGeneral.binarySearch(5);
    }
}
