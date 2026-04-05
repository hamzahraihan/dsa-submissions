class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num ,0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key: hm.keySet()){
            int freq = hm.get(key);
            // System.out.println(freq);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0; i--){
            // System.out.println(buckets[i]);
            if(idx == k)break;
            if(buckets[i] == null)continue;
            for(int num: buckets[i]){
                res[idx] = num;
                idx++;
                if(idx == k)break;
            }
        }
        return res;
    }
}
