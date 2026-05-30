class Solution {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        // int[] dp = new int[nums.length];

        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]); // current dp [1, 1, 0, 0];

        int prev = 0, curr = nums[0];
        for(int i = 2; i <= nums.length; i++){
            int temp = curr;
            curr = Math.max(curr, prev + nums[i - 1]);
            prev = temp;
        }

        return curr;
    }

    // private int dfs(int[] nums, int i){
    //     if(memo.containsKey(i)) return memo.get(i);
    //     if(i >= nums.length) return 0;

    //     // our subproblem
    //     int res = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
    //     memo.put(i, res);
    //     return memo.get(i);
    // }
}
