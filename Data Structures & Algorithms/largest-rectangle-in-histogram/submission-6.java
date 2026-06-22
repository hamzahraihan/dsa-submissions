// monotonic stack
// store the value only if it increasing
class Solution {
    public int largestRectangleArea(int[] heights) {
        // store every index that has the most heights
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int top = stack.pop();
                // find the width area of histogram
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // System.out.println(stack.peek());
                // System.out.println("height: " + top + " width: " + width +  " index: " + i);
                maxArea = Math.max(maxArea, heights[top] * width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            System.out.println("height: " + top + " width: " + width);
            maxArea = Math.max(maxArea, heights[top] * width);
            System.out.println(maxArea);
        }
        return maxArea;
    }
}
