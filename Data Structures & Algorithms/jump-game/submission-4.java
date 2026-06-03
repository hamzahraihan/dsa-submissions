class Solution {
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(0, nums, memo);
    }

    private boolean dfs(int i, int[] nums, Map<Integer, Boolean> memo){
        if(i == nums.length - 1) return true;
        if(nums[i] == 0) return false;
        if(memo.containsKey(i)) return memo.get(i);

        int end = Math.min(nums.length - 1, i + nums[i]);
        for(int j = i + 1; j <= end; j++){
            if(dfs(j, nums, memo)){
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}
