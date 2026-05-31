class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] includeFirstHouse = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] excludeFirstHouse = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(helper(includeFirstHouse), helper(excludeFirstHouse));
    }

    private int helper(int[] nums){
        int[] dp = new int[nums.length + 1];

        int prev = 0, curr = nums[0];

        for(int i = 2; i <= nums.length; i++){
            int temp = curr;
            int rob = Math.max(curr, nums[i - 1] + prev);
            curr = rob;
            prev = temp;
        }
        return curr;
    }
}
