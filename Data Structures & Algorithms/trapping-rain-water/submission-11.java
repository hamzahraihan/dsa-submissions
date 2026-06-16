class Solution {
    public int trap(int[] height) {
        if(height == null) return 0;
        // int res = 0;
        // int n = height.length;

        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];

        // leftMax[0] = height[0];
        // for(int i = 1; i < n; i++){
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]); 
        // }

        // rightMax[n - 1] = height[n - 1];
        // for(int j = n - 2; j >= 0; j--){
        //     rightMax[j] = Math.max(rightMax[j + 1], height[j]); 
        // }
        // for(int i = 0; i < n ; i++){
        //     res += Math.min(leftMax[i],rightMax[i]) - height[i];
        // }
        // return res;

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while(l < r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
