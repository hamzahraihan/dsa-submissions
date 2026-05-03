class Solution {
    // the sign representing direction
    // if both asteroid have the direction they wont met, otherwise they have to collide
    // if the asteroid have bigger size than the other one, then we remove the smaller asteroid 
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        // iterate every asteroids
        for(int a : asteroids){
            // see if stack is not empty and compare top value in stack with asteroids i
            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                // if top stack value is smaller than the current asteroid  
                if(Math.abs(a) > stack.peek()){
                    stack.pop();
                } else if (Math.abs(a) < stack.peek()){ // otherwise if current is smaller than remove the current asteroid
                    a = 0;
                } else { // if both have the same size, than remove both asteroids 
                    a = 0;
                    stack.pop();
                }
            }
            // if the asteroid have value not equal to zero, then pick the asteroid to compare with another 
            if(a != 0){
                stack.add(a);
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}