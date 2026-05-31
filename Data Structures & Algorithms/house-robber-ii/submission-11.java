class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] includeFirstHouse = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] excludeFirstHouse = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(helper(includeFirstHouse), helper(excludeFirstHouse));
    }

    private int helper(int[] nums){
        int[] dp = new int[nums.length + 1];

        dp[1] = nums[0];

        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }
}
