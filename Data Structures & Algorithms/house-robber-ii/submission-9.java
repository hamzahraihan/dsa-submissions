class Solution {
    // rules is simple
    // rob first house but exclude last house, we are not allowed to rob two adjacency house
    Map<String, Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // we search houses with first house included 
        return Math.max(dfs(nums, true, 0), dfs(nums, false, 1));
    }

    private int dfs(int[] nums, boolean flag, int i){
        // we know that flag is to indicate do we rob the first house? if yes then we cant rob the last house  (edge case)
        // also prevent index goes out of bounds
        if(i >= nums.length || (flag && i == nums.length - 1)) return 0;
        // create a key for each house we rob
        String key = i + "," + flag;
        if(memo.containsKey(key)) return memo.get(key);
        
        int res = Math.max(dfs(nums, flag, i + 1), nums[i] + dfs(nums, flag || i == 0, i + 2));
        memo.put(key, res);
        return memo.get(key);
    }
}
