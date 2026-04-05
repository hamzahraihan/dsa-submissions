class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;
        int result = 0;
        while(left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            result = Math.max(result, area);
            if(heights[right] < heights[left] ){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }
}
