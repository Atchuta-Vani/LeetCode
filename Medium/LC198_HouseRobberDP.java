//Tried even and odd sum apprach and it didnot work. 
//Dynamic Programming.
//198. House Robber
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        if(n == 1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],dp[0]);

        for(int i = 2;i< nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
    return dp[n-1];
    }
}
