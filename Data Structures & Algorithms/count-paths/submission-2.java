class Solution {
    /* DP: Top-Bottom */
    // private int[][] memo;
    // public int uniquePaths(int m, int n) {
    //     memo = new int[m][n];
    //     for(int[] len : memo){
    //         Arrays.fill(len, -1);
    //     }
    //     return dfs(0,0,m,n);
    // }

    // private int dfs(int r, int c, int m, int n){
    //     if(r == (m - 1) && c == (n - 1)) return 1;
    //     if(r >= m || c >= n) return 0;
    //     if(memo[r][c] != -1) return memo[r][c];
    //     memo[r][c] = dfs(r, c + 1, m, n) + dfs(r + 1, c, m, n);
    //     return memo[r][c];
    // }


    /* DP: Bottom-Up */
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m + 1][n + 1];
    //     int row = 0, col = 0;

    //     for(int r = m - 1; r >= 0; r--){
    //         for(int c = n - 1; c >= 0; c--){
    //             dp[r][c] += dp[r + 1][c] + dp[r][c + 1]; 
    //         }
    //     }
    //     return dp[0][0];
    // }


    /* DP: Space Optimized */
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);
        for(int i = 0; i < m - 1; i++){
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);

            for(int j = n - 2; j >= 0; j--){
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        return row[0];
    }

}
