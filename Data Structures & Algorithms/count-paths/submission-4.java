class Solution {
    // recursive
    // public int uniquePaths(int m, int n) {
    //     return dfs(0,0,m,n);
    // }

    // private int dfs(int r, int c, int m, int n){
    //     if(r >= (m - 1) && c >= (n - 1)) return 1;
    //     if(r == m || c == n) return 0;

    //     return dfs(r, c + 1, m, n) + dfs(r + 1, c, m,)
    // }

    /* DP: Top-Down */
    private int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dfs(0,0,m,n);
    }

    private int dfs(int r, int c, int m, int n){
        if(r >= (m - 1) && c >= (n - 1)) return 1;
        if(r == m || c == n) return 0;
        if(memo[r][c] != 0) return memo[r][c];

        return memo[r][c] = dfs(r, c + 1, m, n) + dfs(r + 1, c, m,n);
    }
}
