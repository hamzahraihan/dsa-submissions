class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 1; 

        while(low < high){
            System.out.println("high num: " + high);
            int mid = (low + high) / 2;
            System.out.println(mid);
            int lessOrEqual = 0;

            for(int i = 0; i < n; i++){
                if(nums[i] <= mid){
                    lessOrEqual++;
                }
                System.out.println("checking nums[i] <= mid: " + lessOrEqual);
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
