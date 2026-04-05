class Solution {
    public int maxProfit(int[] prices) {
        int current = prices[0];
        int result = 0;
        for(int i = 0 ; i < prices.length;i++){
            if(prices[i] < current) {
                current = prices[i];
            } 
            result = Math.max(result, prices[i] - current);
        }
        System.out.println(current);
        return result;
    }
}
