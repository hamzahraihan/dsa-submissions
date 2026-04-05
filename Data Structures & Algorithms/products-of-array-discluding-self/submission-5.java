 // [1,2,4,6]
 // get prefix number
// prefix[0] = 1
// prefix[1] = prefix[0] (1) * nums[0](1) = (1)
// prefix[2] = prefix[1](1) * nums[1](2) = (2)
// prefix[3] = prefix[2](2) * nums[2](4) = (8)
// we got the prefix number [1,1,2,8]

// get postfix number
// postfix[2] = postfix[3] (1) * nums[3](6) = (6)
// postfix[1] = postfix[2] (6) * nums[2](4) = (24)
// postfix[0] = postfix[1](24) * nums[1](2) = (48)
// we got the postfix number [48,24,6,1]

// find the product of each nums
// prefix[i] * postfix[i] 

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = 1;
        postfix[n-1] = 1;
        for(int i = 1 ; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i -1];
        }

        for(int i = n - 2; i >= 0; i--){
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++){
            res[i] = prefix[i] * postfix[i];
        }

        return res;
    }
}  
