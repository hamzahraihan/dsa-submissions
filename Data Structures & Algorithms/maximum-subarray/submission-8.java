class Solution {
    private Integer[][] memo;

    public int maxSubArray(int[] nums) {
        memo = new Integer[nums.length][2];
        return dfs(nums, 0, 0) ;
    }

    private int dfs(int[] nums, int i, int flag){
        if(i == nums.length - 1) return flag == 1 ? Math.max(0,nums[i]) : nums[i];
        if(memo[i][flag] != null) return memo[i][flag];
        memo[i][flag] = flag == 1 ? Math.max(0, nums[i] + dfs(nums,i + 1, 1))
                                  : Math.max(dfs(nums, i + 1, 0), nums[i] + dfs(nums, i + 1, 1));
        return memo[i][flag];
    }
}
