class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (l + r) / 2;
            int count = 0; 
            for(int i = 0 ; i < n; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }

            if(count <= mid){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
