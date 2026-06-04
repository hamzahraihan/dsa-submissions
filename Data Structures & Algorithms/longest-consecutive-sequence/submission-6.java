class Solution {
    // sliding window
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        int curr = nums[0], streak = 0;
        int l = 0, r = nums.length;
        while(l < r){
            if(curr != nums[l]){
                curr = nums[l];
                streak = 0;
            }
            while(l < r && nums[l] == curr){
                l++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}
