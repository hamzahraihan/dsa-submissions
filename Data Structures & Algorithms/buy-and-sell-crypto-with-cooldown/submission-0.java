class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // create a memo to store max profit from day onwards
        int[][] memo = new int[n][2];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, prices, memo);
    }

    private int dfs(int i, int holding, int[] prices, int[][] memo){
        if(i >= prices.length) return 0;
        if(memo[i][holding] != -1) return memo[i][holding]; 

        int result;
        if(holding == 1){
            int sell = dfs(i + 2, 0, prices, memo) + prices[i];
            int hold = dfs(i + 1, 1, prices, memo);  
            result = Math.max(sell, hold);
        } else {
            int buy = dfs(i + 1, 1, prices, memo) - prices[i];
            int skip = dfs(i + 1, 0, prices, memo);  
            result = Math.max(buy, skip);
        }

        memo[i][holding] = result;
        return result;
    }
}
