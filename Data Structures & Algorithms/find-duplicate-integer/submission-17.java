class Solution {
    public int findDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            int lessOrEqual = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    lessOrEqual++;
                }
            }

            if(lessOrEqual <= mid){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
