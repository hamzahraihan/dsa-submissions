class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        for(int i = 0; i <= n; i++){
            cache[i] = -1;
        }
        return dfs(n, cache);
    }

    private int dfs(int n, int[] cache){
        if(n <= 1) return 1;
        if(cache[n] != -1) return cache[n];
        cache[n] = dfs(n - 1, cache) + dfs(n - 2, cache);
        return cache[n];
    }
}
