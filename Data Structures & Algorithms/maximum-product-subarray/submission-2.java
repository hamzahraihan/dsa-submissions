class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;

        for(int num : nums){
            int temp = num * curMax;
            curMax = Math.max(num, Math.max(num * curMax, num * curMin));
            curMin = Math.min(num, Math.min(temp, num * curMin));
            res = Math.max(res, curMax);
        }
        return res;
    }
}
