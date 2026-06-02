class Solution {
    private int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length + 1][amount + 1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return dfs(amount, 0, coins);
    }

    private int dfs(int a, int i, int[] coins){
        if(a == 0) return 1;
        if(i >= coins.length) return 0;
        if(memo[i][a] != -1) return memo[i][a];


        int res = dfs(a,i + 1, coins);
        if(a >= coins[i]){
            res += dfs(a - coins[i], i, coins);
        }
        memo[i][a] = res;
        return res;
    }
}
