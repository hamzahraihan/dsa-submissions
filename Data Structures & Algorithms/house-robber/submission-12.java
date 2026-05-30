class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(nums.length, nums, memo);
    }

    private int dfs(int i, int[] nums, Map<Integer, Integer> memo){
        if(i == 0) return 0;
        if(i == 1) return nums[0];
        if(memo.containsKey(i)) return memo.get(i);

        int skip = dfs(i - 1, nums, memo);
        int rob =  dfs(i - 2, nums, memo) + nums[i - 1];
        memo.put(i,Math.max(skip, rob));

        return memo.get(i);
    }
}
