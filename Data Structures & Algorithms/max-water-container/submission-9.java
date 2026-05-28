class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n - 1;
        int max = 0;
        while(l < r){
            int area = (r - l) * Math.min(heights[l], heights[r]);
            max = Math.max(max, area);
            if(heights[r] < heights[l]){
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}
