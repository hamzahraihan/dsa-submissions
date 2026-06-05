class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int top = 0;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; 
                maxArea = Math.max(maxArea, heights[top] * width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            top = stack.pop();
            curr = heights[top] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            maxArea = Math.max(maxArea, curr);
        }
        return maxArea;
    }
}
