class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            while(!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0){
                if(Math.abs(asteroids[i]) > stack.peek()){
                    stack.pop();
                } else if(Math.abs(asteroids[i]) < stack.peek()) {
                    asteroids[i] = 0;
                } else {
                    asteroids[i] = 0;
                    stack.pop();
                }
            }
            if(asteroids[i] != 0){
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            res[i] = stack.pop();
        }

        return res;
    }
}