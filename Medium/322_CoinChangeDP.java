/**
    322. Coin Change    
    Initialize array of DP for amount+1;
    fill dp[0] to zero;

    for amount starting from 1 to amount, 
        for each coin   
            if i-coin >= 0 then find min of dp[i], 1+dp[i-coin]
    return dp[amt]
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int coin:coins){
                if(i-coin>=0)
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        if(dp[amount]==amount+1)
            return -1;
        else 
            return dp[amount];
    }
}
