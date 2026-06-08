class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    public int uniquePaths(int m, int n) {
        return dfs(0,0,m,n);
    }
    
    // since we only traverse bottom to right, we only need two variable to traverse matrix
    private int dfs(int i, int j,int m, int n){
        // if we reach our destination, add point by 1
        if(i == (m - 1) && j == (n - 1)) return 1;

        String key = i + "." + j;
        if(memo.containsKey(key)) return memo.get(key);

        // if we out of bound return 0
        if(i >= m || j >= n) return 0;
        memo.put(key, dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n));
        return memo.get(key);
    }
}
