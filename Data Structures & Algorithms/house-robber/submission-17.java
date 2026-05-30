class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i){
        if(memo.containsKey(i)) return memo.get(i);
        if(i >= nums.length) return 0;

        int res = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
        memo.put(i, res);
        return memo.get(i);
    }
}
