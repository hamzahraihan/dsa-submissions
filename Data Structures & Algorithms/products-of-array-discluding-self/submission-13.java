class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, zeroCount = 0;
        for(int n : nums){
            if(n == 0){
                zeroCount++;
            }else {
                prod *= n;
            }
        }

        if(zeroCount >= 2){
            return new int[nums.length];
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(zeroCount >= 1){
                res[i] = (nums[i] == 0) ? prod : 0;
            } else {
                res[i] = prod / nums[i];
            }
        }
        return res;
    }
}  
