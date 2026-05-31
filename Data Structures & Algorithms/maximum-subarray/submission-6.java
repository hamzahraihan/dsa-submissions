class Solution {
    Map<String, Integer> memo = new HashMap<>();
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, false) ;
    }

    private int dfs(int[] nums, int i, boolean flag){
        if(i == nums.length - 1) return flag ? Math.max(0,nums[i]) : nums[i];

        String key = i + "," + flag;
        if(memo.containsKey(key)) return memo.get(key);

        if(flag) return Math.max(0,nums[i] + dfs(nums, i + 1, true));
        int res = Math.max(dfs(nums, i + 1, false), nums[i] + dfs(nums, i + 1, true)); 
        memo.put(key, res);
        return memo.get(key);
    }
}
