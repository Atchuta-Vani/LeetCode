/**
Steps:
Initialization:

Create a dp[] array of the same size as the input array nums[].

Set dp[0] to nums[0] because the maximum subarray ending at the first element is the element itself.

Initialize maxSum to dp[0] to keep track of the largest sum found.

Recurrence Relation:

For each element starting from index 1, compute the maximum sum of the subarray that ends at that element. This is done by considering:

Either the element nums[i] itself (i.e., starting a new subarray), or

The element nums[i] added to the previous maximum subarray sum (dp[i-1]).

dp[i]=max(nums[i],dp[i−1]+nums[i])
After updating dp[i], update the global maxSum to be the maximum of maxSum and dp[i].

Result:

The final result will be the value of maxSum, which contains the largest subarray sum.

 */

public class Solution {
    public int maxSubArray(int[] nums) {
        // Handle the case where the input array is empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Create the dp array and initialize the first element
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        // Initialize maxSum with the first element
        int maxSum = dp[0];

        // Start iterating from the second element
        for (int i = 1; i < nums.length; i++) {
            // Recurrence relation: Max of starting a new subarray or extending the previous one
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            
            // Update maxSum to keep track of the maximum subarray sum
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
