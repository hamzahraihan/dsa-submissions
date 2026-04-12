class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int res = 0;

        for(int i = 0; i < height.length; i++){
            int maxLeft = height[i];
            int maxRight = height[i];

            for(int j = 0; j < i; j++){
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for(int k = i + 1; k < n; k++){
                maxRight = Math.max(maxRight, height[k]);
            }

            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }
}
