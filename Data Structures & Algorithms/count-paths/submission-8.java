class Solution {
    // private Map<String, Integer> memo = new HashMap<>();
    // public int uniquePaths(int m, int n) {
    //     return dfs(0,0,m,n);
    // }
    
    // // since we only traverse bottom to right, we only need two variable to traverse matrix
    // private int dfs(int i, int j,int m, int n){
    //     // if we reach our destination, add point by 1
    //     if(i == (m - 1) && j == (n - 1)) return 1;

    //     String key = i + "." + j;
    //     if(memo.containsKey(key)) return memo.get(key);

    //     // if we out of bound return 0
    //     if(i >= m || j >= n) return 0;
    //     memo.put(key, dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n));
    //     return memo.get(key);
    // }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}
