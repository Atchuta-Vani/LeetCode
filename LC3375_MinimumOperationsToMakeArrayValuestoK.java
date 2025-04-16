/**
Hint: Number of distinct integers greater than k is the solution. 

Find the largest and replace with second largest. 
if the number is less than k, return -1. 
if the number is greater than k, keep adding it to set and return size of set at the end. 
 */
class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        for(int num:nums){
            if(num>k){
                set.add(num);
            }
            if(num<k)
                return -1;
        }
        return set.size();
    }
}
