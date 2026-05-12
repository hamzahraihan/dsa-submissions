class Solution {
    // every asteroids came from different direction, the right one marked with positive value, the left one marked with negative value 
    // if the collisions happened, the small asteroid will be destroyed.
    // but if asteroid came from the same direction, collisions will never happened

    // to solve this problem, we can use stack data structure to store each asteroid
    // so we must check first in every iteration, if asteroids is negative or below zero (asteroids < 0) AND if asteroids is positive or higher than zero (asteroids > 0); 
    // then we can proceed to check which asteroid is bigger
    // if the small asteroid is in stack, we can use pop
    // if the small asteroid is in array, we can change the value to 0 (mark it as destroyed asteroid)
    // after we done with the loop, we can proceed to insert to empty array
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            while(!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0 ){
                if(stack.peek() > Math.abs(asteroids[i])){
                    asteroids[i] = 0;
                } else if(stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
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