public class Candy {

    public int candy(int[] ratings) {

        int []candies= new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i-1]<ratings[i]){
                candies[i]=candies[i-1]+1;
            }
        }
        for (int i = ratings.length-2; i >=0; i--) {
            if(ratings[i+1]<ratings[i]){
                candies[i]=Math.max(candies[i+1]+1,candies[i]);
            }
        }
        int count=0;
        for (int candy : candies) {
            count += candy;
        }

        return count;
    }

}
