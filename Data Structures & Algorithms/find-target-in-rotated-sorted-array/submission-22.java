class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) { 

            int mid = (l + r) / 2;

            // System.out.println(l);
            // System.out.println(mid);
            if(nums[mid] == target) { 
                return mid;
            }

            if(nums[l] <= nums[mid]) { // search number from left segment [3,4,5]
                // if target is higher than the mid number  
                // or if target is lower than left number
                if(nums[mid] < target || target < nums[l]) { 
                    l = mid + 1; // move left pointer to mid + 1
                } else { // if none conditions are met (target number is higher than left number or lower than mid number)
                    r = mid - 1;
                }
            } else { // search number from the right segment [6,1,2]
                if(nums[mid] > target || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
