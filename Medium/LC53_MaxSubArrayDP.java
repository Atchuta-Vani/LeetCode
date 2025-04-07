/**
Steps:
Create a dp[] array of the same size as the input array nums[].

Set dp[0] to nums[0] because the maximum subarray ending at the first element is the element itself.
Initialize maxSum to dp[0] to keep track of the largest sum found.

Recurrence Relation:
For each element starting from index 1, till end of array

    Either the element nums[i] itself (i.e., starting a new subarray), or
    The element nums[i] added to the previous maximum subarray sum (dp[i-1]).

    dp[i]=max(nums[i],dp[i−1]+nums[i])
    After updating dp[i], update the global maxSum to be the maximum of maxSum and dp[i].
return maxSum
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        maxSum = dp[0];

        for(int i =1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            maxSum = Math.max(maxSum,dp[i]);
        }
    return maxSum;
    }
}    
