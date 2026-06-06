class Solution {
    private Boolean[] memo;
    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length + 1];
        return dfs(0, nums);
    }

    private boolean dfs(int i, int[] nums){
        if(i == nums.length - 1) return true;
        if(nums[i] == 0) return false;
        if(memo[i] != null) return memo[i];

        int end = Math.min(nums.length - 1, i + nums[i]);
        for(int j = i + 1; j <= end; j++){
            if(dfs(j, nums)){
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }

}
