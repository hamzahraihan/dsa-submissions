class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxStone = 0;
        for(int stone : stones){
            maxStone = Math.max(maxStone, stone);
        }

        int[] bucket = new int[maxStone + 1];
        for(int stone : stones){
            bucket[stone]++;
        }

        int first = maxStone, second = maxStone;
        // check if stone is above 0
        while(first > 0){
            // check if bucket has even number of stones
            if(bucket[first] % 2 == 0){
                // since we know that we are in the rightest bucket (right bucket == largest stone)
                // move the bucket to the left
                first--;
                continue;
            }

            // find the low weight stone
            int j = Math.min(first - 1, second);
            // if bucket does not contain any stone, move the pointer to the left
            while(j > 0 && bucket[j] == 0){
                j--;
            }
            // if pointer is 0, return current stone
            if(j == 0){
                return first;
            }

            // calculate the stone(remove stone, add new stone, keep stone to be prepared for smash)
            // move bucket of stone to next bucket
            second = j;
            // remove the stone after it smashed
            bucket[first]--;
            bucket[second]--;
            // calculate the stone
            bucket[first - second]++;
            // keep the stone
            first = Math.max(first - second, second);
        }
        return first;
    }
}
