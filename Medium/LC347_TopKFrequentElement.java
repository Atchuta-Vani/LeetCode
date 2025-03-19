/**
Step 1: Count the frequency of each element using a HashMap.
Step 2: Use a Min-Heap (priority queue) to keep track of the k most frequent elements.
Step 3: Return the top k elements.
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        
        Map<Integer,Integer> map = new HashMap();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>((a,b) -> a.getValue() - b.getValue());
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int j = 0;j<k;j++){
           Map.Entry<Integer,Integer> entry = pq.poll();
           int key = entry.getKey();
           result[j] = key;
        }
    return result;
    }
}
