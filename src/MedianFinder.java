import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap,maxHeap;
    public MedianFinder() {
    minHeap=new PriorityQueue<>();
    maxHeap= new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
        }
        else if(maxHeap.peek()<=num){
            minHeap.offer(num);
        }
        else{
            maxHeap.offer(num);

        }

        if(Math.abs(minHeap.size()-maxHeap.size())>=2){
            if(minHeap.size()>maxHeap.size()){
                int data=minHeap.poll();
                maxHeap.offer(data);
            }
            else{
                if(!maxHeap.isEmpty()) {
                    int data = maxHeap.poll();
                    minHeap.offer(data);
                }
            }

        }
    }

    public double findMedian() {
        if (!maxHeap.isEmpty()) {


            if (minHeap.size() == maxHeap.size()) {
                int val1 = minHeap.peek();
                int val2 = maxHeap.peek();
                return (double) (val1 + val2) / 2;
            }
            else if(minHeap.size()> maxHeap.size()){
                    return minHeap.peek();
            }
            else{
                return maxHeap.peek();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        int[] nums = {1, 3, 5, 6, 4};
        for (int num : nums) {
            mf.addNum(num);
            System.out.println("Median after " + num + " = " + mf.findMedian());
        }
    }

}