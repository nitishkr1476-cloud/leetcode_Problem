import java.util.*;
//class MedianFinder {

   // public MedianFinder() {
        
   // }
    
  //  public void addNum(int num) {
        
  //  }
    
 //   public double findMedian() {
        
  //  }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
class MedianFinder {

    // Max heap for smaller half
    private PriorityQueue<Integer> small;

    // Min heap for larger half
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        // Add to max heap
        small.offer(num);

        // Maintain order property
        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }

        // Balance sizes
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        
        // Odd number of elements
        if (small.size() > large.size()) {
            return small.peek();
        }

        // Even number of elements
        return (small.peek() + large.peek()) / 2.0;
    }
}