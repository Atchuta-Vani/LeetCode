/**
1004 - Max Consecutive Ones |||
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

use sliding window. 
left pointers starts at 0. right pointer goes from 0 to end of nums length in a for loop.
keep zeroCount and increment it when you see zero.

if zeroCount > k, if left char is 0, - >decrement zeroCount.
increment left pointer. 

calculate max before end of for.
return max value. 
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeroCount =0;
        int maxLength = Integer.MIN_VALUE;
        for(int right = 0; right<nums.length;right++){
            if(nums[right] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            

        maxLength = Math.max(maxLength, right-left+1);
        }
    return maxLength;        
    }
}
