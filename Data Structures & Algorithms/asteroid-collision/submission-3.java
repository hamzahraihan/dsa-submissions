class Solution {
    // the sign representing direction
    // if both asteroid have the direction they wont met, otherwise they have to collide
    // if the asteroid have bigger size than the other one, then we remove the smaller asteroid 
    public int[] asteroidCollision(int[] asteroids) {
        int j = -1;
        // iterate every asteroids
        for(int a : asteroids){
            // compare asteroid with the last one we iterated 
            while(j >= 0 && asteroids[j] > 0 && a < 0){
                // if right asteroid is larger than left asteroid, we remove the left one by marking it with 0
                if(asteroids[j] > Math.abs(a)){
                    a = 0;
                    break;
                } else if (asteroids[j] == Math.abs(a)){ // if both have the same size, than remove both asteroids
                    j--;
                    a = 0;
                    break;
                } else { // if asteroid destroyed, we skip it
                    j--;
                }
            }
            // if the asteroid have value not equal to zero, then pick the asteroid to compare with another 
            if(a != 0){
                j++;
                asteroids[j] = a;
            }
        }
        return Arrays.copyOfRange(asteroids, 0, j + 1);
    }
}