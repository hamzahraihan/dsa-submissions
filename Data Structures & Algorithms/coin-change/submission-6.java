// we can use DP to store minimum coins
class Solution {
    // doing recursively find any coins that match the amount
    // we can assume that we have unlimited coins
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {     
        // instantiate a variable to store coins
        int minCoins = dfs(coins, amount);
        // check if the coins could make up to the amount, if it is not return -1 
        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

    private int dfs(int[] coins, int amount){
        // edge case
        // return 0 if amount is 0
        if(amount == 0) return 0;
        if(memo.containsKey(amount)) return memo.get(amount);

        // current minimum coins
        int res = Integer.MAX_VALUE;
        for(int coin : coins ){
            // check if we can use the coin
            if(amount - coin >= 0){
                // recursively find another coin
                int result = dfs(coins, amount - coin);
                // if we found the coin, we can store it to variable
                if(result != Integer.MAX_VALUE){
                    res = Math.min(res, 1 + result);
                }
            }
        }
        memo.put(amount, res);
        return res;
    }
}
