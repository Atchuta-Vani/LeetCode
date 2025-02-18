//121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int n :prices){
            if(n < minPrice){
                minPrice = n;
            }
            if(maxProfit < n-minPrice){
                maxProfit = n-minPrice;
            }
        }
        return maxProfit;
    }
}
