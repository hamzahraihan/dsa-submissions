class Solution {
    // private Integer[][] memo;

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];

        dp[n - 1][1] = nums[n - 1];
        dp[n - 1][0] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            dp[i][1] = Math.max(nums[i], nums[i] + dp[i + 1][1]);
            dp[i][0] = Math.max(dp[i + 1][0], dp[i][1]);
        }
        return dp[0][0];
    }

    // public int maxSubArray(int[] nums) {
    //     memo = new Integer[nums.length][2];
    //     return dfs(nums, 0, 0) ;
    // }

    // private int dfs(int[] nums, int i, int flag){
    //     if(i == nums.length - 1) return flag == 1 ? Math.max(0,nums[i]) : nums[i];
    //     if(memo[i][flag] != null) return memo[i][flag];
    //     memo[i][flag] = flag == 1 ? Math.max(0, nums[i] + dfs(nums,i + 1, 1))
    //                               : Math.max(dfs(nums, i + 1, 0), nums[i] + dfs(nums, i + 1, 1));
    //     return memo[i][flag];
    // }
}
