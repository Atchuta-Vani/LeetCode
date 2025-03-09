//LC - 378 
//Find Kth smallest element. 
// Use Max Heap by passing comparator. 
//O(n) - O(nlog k) - n is total elements matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,(a,b)->b-a); //Max Heap of size k
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        if(!pq.isEmpty())
            return pq.poll().intValue();
        return -1;
    }
}
