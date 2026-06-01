class Solution {
    Map<String, Integer> memo = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(0, 0, text1, text2);
    }

    private int dfs(int i, int j, String text1, String text2){
        if(i == text1.length() || j == text2.length()) return 0;
        String key = i+","+j;
        if(memo.containsKey(key)) return memo.get(key);
        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + dfs(i + 1, j + 1, text1, text2);
        }
        memo.put(key, Math.max(dfs(i + 1, j, text1, text2), dfs(i, j + 1, text1, text2)));
        return memo.get(key);
    }
}
