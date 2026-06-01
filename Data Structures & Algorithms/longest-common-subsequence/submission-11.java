class Solution {
    // private int[][] memo;
    // public int longestCommonSubsequence(String text1, String text2) {
    //     memo = new int[text1.length()][text2.length()];
    //     return dfs(0, 0, text1, text2);
    // }

    // private int dfs(int i, int j, String text1, String text2){
    //     if(i == text1.length() || j == text2.length()){
    //         return 0;
    //     }
    //     if(memo[i][j] != 0){
    //         return memo[i][j];
    //     }
    //     if(text1.charAt(i) == text2.charAt(j)){
    //         memo[i][j] = 1 + dfs(i + 1, j + 1, text1, text2);
    //     } else {
    //         memo[i][j] = Math.max(dfs(i, j + 1, text1, text2), dfs(i + 1, j, text1, text2));
    //     }

    //     return memo[i][j];
    // }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    //     for(int i = text1.length() - 1; i >= 0; i--){
    //         for(int j = text2.length() - 1; j >= 0; j--){
    //             if(text1.charAt(i) == text2.charAt(j)){
    //                 dp[i][j] = 1 + dp[i + 1][j + 1];
    //             } else {
    //                 dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
    //             }
    //         }
    //     }
    //     return dp[0][0];
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() < text2.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];

        for(int i = text1.length() - 1; i >= 0; i--){
            for(int j = text2.length() - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    curr[j] = 1 + prev[j + 1];
                } else {
                    curr[j] =  Math.max(curr[j + 1],prev[j]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[0];
    }
}
