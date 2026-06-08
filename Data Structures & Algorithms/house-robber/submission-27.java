class Solution {
    // private int[] memo;
    // public int rob(int[] nums) {
    //     memo = new int[nums.length];
    //     Arrays.fill(memo, - 1);
    //     return dfs(0, nums);
    // }

    // private int dfs(int i, int[] nums){
    //     if(i >= nums.length) return 0;
    //     if(memo[i] != -1) return memo[i];

    //     memo[i] = Math.max(dfs(i + 1, nums), nums[i] + dfs(i + 2, nums)); 
    //     return memo[i];
    // }

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }
}
