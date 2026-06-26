class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = nums[0];
        while(l <= r) { 
            if(nums[l] < nums[r]){

                res = Math.min(res, nums[l]);
                break;
            }

            int mid = (l + r) / 2;
            res = Math.min(res, nums[mid]);
            if(nums[l] <= nums[mid]){ // if nums[l] is smaller than nums[mid] (3) < (5)
                l = mid + 1; // change l to mid
            } else { // if nums[r] is bigger than nums[mid]
                r = mid - 1; // change r to mid
            }

        }
        return res;
    }
}
