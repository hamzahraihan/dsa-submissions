class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // lowest speed
        int l = 1;

        // highest speed
        int r = piles[0];

        // find the most pile of banana
        for(int pile : piles){
            r = Math.max(r, pile);
        }
        int res = r;

        while(l <= r){
            int speed = (l + r) / 2;
            long totalTime = 0;
            for(int p : piles){
                totalTime += Math.ceil((double) p / speed);
            }
            if(totalTime <= h){
                res = speed;
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }
        return res;
    }
}
