class Solution {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length + 1];

        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }

        return dp[nums.length];
    }

    // private int dfs(int[] nums, int i){
    //     if(memo.containsKey(i)) return memo.get(i);
    //     if(i >= nums.length) return 0;

    //     // our subproblem
    //     int res = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
    //     memo.put(i, res);
    //     return memo.get(i);
    // }
}
