public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            if((i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0) && flowerbed[i]!=1){
                flowerbed[i]=1;
                n--;
            }
        }
        return n<=0;
    }
    public static void main(String[] args) {
        CanPlaceFlowers sol = new CanPlaceFlowers();

        System.out.println(sol.canPlaceFlowers(new int[]{1,0,0,0,1}, 1)); // true
        System.out.println(sol.canPlaceFlowers(new int[]{1,0,0,0,1}, 2)); // false
        System.out.println(sol.canPlaceFlowers(new int[]{0,0,1,0,0,0,1}, 2)); // true
    }

}
