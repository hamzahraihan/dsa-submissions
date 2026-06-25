class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = nums[0];
        while(l <= r){
            // check if we find a number left smaller than numer right  
            if(nums[l] < nums[r]){
                res = (res > nums[l]) ? nums[l] : res;
                break;
            }

            // split half the array
            int m = (l + r) / 2;
            System.out.println(m);
            // take the middle number as a result if it is the smallest 
            res = Math.min(res,nums[m]);
            System.out.println(res);
            // check if mid number is larger or smaller than number left
            // if mid number is higher than the left, meaning that smallest number is on the right side
            // otherwise smallest number is on the right side
            if(nums[l] <= nums[m]){ 
                l = m + 1;
            } else { // if right number is bigger than mid number
                r = m - 1;
            }
            // note: from left to mid will be the left sorted segment, the mid to right will be the right sorted 
            // so find the smallest number we found in left and right segment
        }
        return res;
    }
}
