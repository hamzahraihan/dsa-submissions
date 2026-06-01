class Solution {
    private int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                memo[i][j] = -1;
            }
        }

        return dfs(0, 0, text1, text2);
    }

    private int dfs(int i, int j, String text1, String text2){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + dfs(i + 1, j + 1, text1, text2);
        } else {
            memo[i][j] = Math.max(dfs(i, j + 1, text1, text2), dfs(i + 1, j, text1, text2));
        }

        return memo[i][j];
    }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    //     return dp[0];
    // }
}
