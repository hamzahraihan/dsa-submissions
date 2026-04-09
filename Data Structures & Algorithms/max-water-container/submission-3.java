class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxarea = 0; 
        while(l < r){
            int area = (r - l) * Math.min(heights[l], heights[r]);
            maxarea = Math.max(maxarea, area);
            if(heights[r] < heights[l]){
                r--;
            } else {
                l++;
            }
        }
        return maxarea;
    }
}
