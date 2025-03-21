/**
//295 - find Median from Data Stream

Approach 1: use list and add numbers to it. 
findMedian:
        Sort the collection.
        for odd length, return middle number.
        for even length, return average of middle numbers

Approach 2: Use two Prioirty Queues (smallHeap and largeHeap)
add Num: always add it to small Heap.
         if size of small heap is > large heap or smallHeap peak is greater than large heap peek
         poll top element of smallHeap and put it in large heap.

find Median: if size of PQs are same, peek top elements and return average. 
             If size of small Heap is more, return smallHeap peek 
             or return large heap peek. 
 */

class MedianFinder {

    Queue<Integer> smallHeap;
    Queue<Integer> largeHeap;
    public MedianFinder() {
        smallHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        largeHeap = new PriorityQueue<Integer>( (a,b) -> a - b);
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);

        if(smallHeap.size() - largeHeap.size() >= 1 || !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()){
            largeHeap.offer(smallHeap.poll());
        }
        if(largeHeap.size() - smallHeap.size() >= 1){
            smallHeap.offer(largeHeap.poll());
        }
        //System.out.println("Small heap  "+smallHeap+" largeHeap "+largeHeap);
    }
    
    public double findMedian() {
        double median =0;
        if(largeHeap.size() == smallHeap.size()){
            median = (largeHeap.peek() + smallHeap.peek())/2.0;
        }else if(largeHeap.size() > smallHeap.size()){
            median =  largeHeap.peek();
        }else if(largeHeap.size() < smallHeap.size()){
            median = smallHeap.peek();
        }
    return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
