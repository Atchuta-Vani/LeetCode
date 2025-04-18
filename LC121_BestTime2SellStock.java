/**
Buy low, sell high.
One Pass (Greedy)
Keep track of the lowest price as you go.
At each step, calculate potential profit = current price - min_price.
Update the max profit if this one is higher.

 */

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        if(prices == null || prices.length == 1)
            return 0;
        for(int i = 0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);            
        }
        
        return max;
    }
}
