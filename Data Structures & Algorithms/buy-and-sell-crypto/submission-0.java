class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int left = 0; left < prices.length; left++){
            for(int right = left + 1; right < prices.length; right++){
                int currProfit = prices[right] - prices[left];
                if(currProfit > profit){
                    profit = currProfit;
                }
            }
        }
        return profit;
    }
}
