class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i){
        if(memo.containsKey(i)) return memo.get(i);
        if(i >= cost.length) return 0;
        memo.put(i, cost[i] + Math.min(dfs(cost,i + 1), dfs(cost, i + 2)));
        return memo.get(i);
    }
}
