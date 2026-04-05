class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int total = 1; 
        for(int num : nums){
            if(num == 0) zeroCount++;
            else total *= num;
        }
        System.out.println(total);
        for(int i = 0; i < nums.length;i++){
           if (zeroCount > 1) {
                nums[i] = 0;
            }
            else if (zeroCount == 1) {
                if (nums[i] == 0) nums[i] = total;
                else nums[i] = 0;
            }
            else {
                nums[i] = total / nums[i];
            }
        }
        return nums;
    }
}  
