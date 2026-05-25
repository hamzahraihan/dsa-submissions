class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>(); 
        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int i, Map<Integer, Integer> memo){
        if(i >= nums.length) return 0;
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        memo.put(i, Math.max(dfs(nums, i + 1, memo), nums[i] + dfs(nums, i + 2, memo)));
        return memo.get(i);
    }
}
