class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l <= r){
            int k = (l + r) / 2;
            System.out.println(k);

            int totalTime = 0;
            for(int pile : piles) { 
                totalTime += (int) Math.ceil((double) pile / k);
                System.out.println("pile of: " + pile + " with total time: " + totalTime);
            }
            if(totalTime <= h){
                res = k;
                r = k - 1;
            } else { 
                l = k + 1;
            }
        }
        System.out.println(res);
        return res;
    }
}
