class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                result[stack.peek()[1]] = i - stack.pop()[1];
            }
            stack.push(new int[] {t, i});
        }
        return result;
    }

}
