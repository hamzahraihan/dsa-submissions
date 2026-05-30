class Solution {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int rob1 = nums[0], rob2 = Math.max(nums[0], nums[1]); 
        for(int i = 2; i < nums.length; i++){
            int temp = rob2;
            int newRob = Math.max(rob2, nums[i] + rob1);
            rob1 = temp; 
            rob2 = newRob; 
        }

        return rob2;
    }
}
