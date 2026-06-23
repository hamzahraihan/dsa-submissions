class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r) { 
            int mid = (l + r) / 2;
            System.out.println(mid);
            if(nums[mid] == target) { 
                return mid;
            }

            if(nums[mid] < target) { 
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
