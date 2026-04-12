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
                // System.out.println("height: j " + height[j] + " at index j " + j);
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for(int k = i + 1; k < n; k++){
                // System.out.println("height: k " + height[k] + " at index k " + k);
                maxRight = Math.max(maxRight, height[k]);
            }


            // System.out.println("");
            // System.out.println("height: i " + height[i] + " at index i " + i);
            // System.out.println("");

            // System.out.println("maxleft: " + maxLeft);
            // System.out.println("maxRight: " + maxRight);

            res += Math.min(maxLeft, maxRight) - height[i];

            // System.out.println("res: " + res);
        }
        return res;
    }
}
