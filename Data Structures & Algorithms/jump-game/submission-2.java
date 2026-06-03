class Solution {
    public boolean canJump(int[] nums) {
        return dfs(0, nums);
    }

    private boolean dfs(int i, int[] nums){
        if(i == nums.length - 1) return true;
        int end = Math.min(nums.length - 1, i + nums[i]);
        for(int j = i + 1; j <= end; j++){
            if(dfs(j, nums)){
                return true;
            }
        }
        return false;
    }
}
