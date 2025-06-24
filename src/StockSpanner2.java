public class StockSpanner2 {

    int[]map;
    int day=0;
    public StockSpanner2() {
        map=new int[100001];
    }

    public int next(int price) {
        day++;

        int count=-1;
        int tempPrice=price;
        while (map[tempPrice--]>0 && tempPrice<100001){
            count=tempPrice-price;
        }
        map[price]=day;
        if(tempPrice>=100001){
            return 1;
        }
        return count;
    }

    public static void main(String[] args) {
        StockSpanner2 stockSpanner2 = new StockSpanner2();

        System.out.println(stockSpanner2.next(28)); // Expected: 1
        System.out.println(stockSpanner2.next(14)); // Expected: 1
        System.out.println(stockSpanner2.next(28)); // Expected: 3
        System.out.println(stockSpanner2.next(35)); // Expected: 4
        System.out.println(stockSpanner2.next(46)); // Expected: 5
        System.out.println(stockSpanner2.next(53)); // Expected: 6
        System.out.println(stockSpanner2.next(66)); // Expected: 7
        System.out.println(stockSpanner2.next(80)); // Expected: 8
        System.out.println(stockSpanner2.next(87)); // Expected: 9
        System.out.println(stockSpanner2.next(88)); // Expected: 10
    }

}
