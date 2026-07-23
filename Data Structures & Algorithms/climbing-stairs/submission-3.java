class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(n , memo);
    }

    private int dfs(int n, Map<Integer, Integer> memo){
        if(n <= 1) return 1;
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        memo.put(n, dfs(n - 1, memo) + dfs(n - 2, memo));
        return memo.get(n);
    }
}
