//697 Degree of an Array.

/**
We want the shortest subarray that includes all occurrences of the most frequent element(s).

Steps:
Calculate degree of the array.

For each number, store:

First occurrence
Last occurrence
Frequency

For all numbers with frequency == degree:
Calculate length = last - first + 1
Track the minimum length
 */

class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer,Integer> freQMap = new HashMap();
        Map<Integer,Integer> firstMap = new HashMap();
        Map<Integer,Integer> lastMap = new HashMap();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            freQMap.put(n,freQMap.getOrDefault(n,0)+1);
            if(!firstMap.containsKey(n)){
                firstMap.put(n,i);
            }
            lastMap.put(n,i);
        }

        int max = Collections.max(freQMap.values());
        int minLength = nums.length;

        for(Map.Entry<Integer,Integer> entry: freQMap.entrySet()){
            if(entry.getValue() == max){
                int num = entry.getKey();
                int first = firstMap.get(num);
                int last = lastMap.get(num);
                minLength = Math.min(minLength, last-first+1);
            }
        }
    return minLength;
    }
}
