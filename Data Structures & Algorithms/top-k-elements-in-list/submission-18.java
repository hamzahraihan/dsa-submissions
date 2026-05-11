class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count the frequency on each input value in nums array
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // count freq
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1]; 
        for(int key : count.keySet()){
            int freq = count.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        System.out.println(Arrays.toString(buckets));

        int[] res = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] == null) continue;
            if(idx == k) break;
            for(int bucket : buckets[i]){
                res[idx++] = bucket;

            }
        }

        return res;
    }
}
