class Solution {
    public int[] productExceptSelf(int[] nums) {
      
        int zeroCount = 0;
        int total = 1;
        for(int i = 0; i < nums.length;i++ ){
            if(nums[i] == 0) zeroCount++;
            else total *= nums[i];
        }
        if(zeroCount > 1){
            return new int[nums.length];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            if(zeroCount > 0)  res[i] = (nums[i] == 0) ? total : 0;
            else res[i] = total / nums[i];
        }
        System.out.println(total);
        return res;
    }
}  
