class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            while(!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0){
                int diff = asteroids[i] + stack.peek();
                if(diff < 0){
                    stack.pop();
                } else if(diff > 0){
                    asteroids[i] = 0;
                } else {
                    asteroids[i] = 0;
                    stack.pop();
                }
            }

            if(asteroids[i] != 0){
                stack.add(asteroids[i]);
            }
        }

        int[] res  = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }

        return res;
    }
}