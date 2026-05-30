class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev = 0, curr = nums[0];
        for(int i = 2; i <= nums.length; i++){
            int temp = curr;
            curr = Math.max(prev + nums[i - 1],curr);
            prev = temp;
        }
        return curr;
    }

}
