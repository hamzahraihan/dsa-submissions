class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : count.keySet()){
            int freq = count.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] == null) continue;
            if(idx == k) break;
            for(int num : buckets[i]){
                result[idx++] = num;
                if(idx == k) break;
            }
        }
        return result;
    }
}
