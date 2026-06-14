class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int num : count.keySet()){
            int cnt = count.get(num);
            if(buckets[cnt] == null){
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(num);
        }


        int[] res = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i > 0 && idx < k; i--){
            if(buckets[i] == null) continue;
            for(int bucket : buckets[i]){
                res[idx++] = bucket;
            }
        }
        
        return res;
    }
}
