import java.util.*;

class StockPrice {
    HashMap<Integer, Integer> map;
    TreeMap<Integer, Integer> priceTS;
    TreeSet<Integer> timeTS;
    int max = 0;
    int recent = 0;
    int min = 0;

    public StockPrice() {
        map = new HashMap<>();
        priceTS = new TreeMap<>();
        timeTS = new TreeSet<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            int c = priceTS.get(oldPrice);
            if (c == 1)
                priceTS.remove(oldPrice);
            else
                priceTS.put(oldPrice, c - 1);

            int d = priceTS.getOrDefault(price, 0);
            priceTS.put(price, d + 1);
            map.put(timestamp, price);
        } else {
            map.put(timestamp, price);
            int d = priceTS.getOrDefault(price, 0);
            priceTS.put(price, d + 1);
            timeTS.add(timestamp);
        }
        max = priceTS.lastKey();
        int ts = timeTS.last();
        min = priceTS.firstKey();
        recent = map.get(ts);
    }

    public int current() {
        return recent;
    }

    public int maximum() {
        return max;
    }

    public int minimum() {
        return min;
    }



    public static void main(String[] args) {
        StockPrice sp = new StockPrice();

        // Initial updates
        sp.update(1, 100);
        sp.update(2, 100);
        sp.update(3, 100);
        sp.update(1, 10);
        System.out.println(sp.current());
        System.out.println(sp.maximum());
        System.out.println(sp.minimum());

    }

}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */