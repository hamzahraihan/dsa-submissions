class Solution {
    public int lastStoneWeight(int[] stones) {
        // initialize the most weight stone
        int maxStone = 0;
        for(int stone : stones){
            maxStone = Math.max(maxStone, stone);
        }

        // store a stone in bucket with each weight
        int[] bucket = new int[maxStone + 1];
        for(int stone : stones){
            bucket[stone]++;
        }

        int first = maxStone, second = maxStone;
        // if we still have a stone, we keep loop
        while(first > 0){
            // see if we have even total number of stone 
            if(bucket[first] % 2 == 0){ // we skip the stone
                first--;
                continue;
            }

            // check if we have smaller stone
            int j = Math.min(first - 1, second);
            // if bucket[j] does not contain any stone (bucket[j] == 0)
            // we skip the bucket
            while(j > 0 && bucket[j] == 0){
                j--;
            }
            // if stone is 0, store the stone in variable 
            if(j == 0){
                return first;
            }
            // move the second stone
            second = j;
            // remove stone 
            bucket[first]--;
            bucket[second]--;

            // store a stone after we smash them  
            bucket[first - second]++;
            // put the most weight stone to preparing for smashing it with other stone
            first = Math.max(first-second, second);
        }

        // return the stone left
        return first;
    }
}
