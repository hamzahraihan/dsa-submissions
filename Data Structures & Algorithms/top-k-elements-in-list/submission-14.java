class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();

        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key: hm.keySet()){
            int freq = hm.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList();
            }

            buckets[freq].add(key);
        }


        int[] res = new int[k];
        int i  = 0;
        for(int j = buckets.length - 1; j >= 0 && i < k;j--){
            if(buckets[j] == null)continue;
            for(int num : buckets[j]){
                res[i++] = num;
            }
        }

        return res;
    }
}
