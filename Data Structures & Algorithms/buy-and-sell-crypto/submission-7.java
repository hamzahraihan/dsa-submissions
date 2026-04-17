class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int buy = prices[0];
        int sell = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < buy){
                buy = Math.min(buy, prices[i]);
            }
            int profit = prices[i] - buy;
            maxP = Math.max(maxP, profit);
        }
        return maxP;
    }
}
