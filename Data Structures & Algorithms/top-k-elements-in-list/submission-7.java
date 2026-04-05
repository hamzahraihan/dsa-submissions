class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count frequency
        Map<Integer,Integer> count = new HashMap<>();
        int[] freq = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // bucket sort ( index = frequency)
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : count.keySet()) {
            int frequency = count.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        for(int i : freq){
            System.out.println(i);
        }
        
        //  collect top k frequent
        int[] res = new int[k];
        int idx = 0;
         for (int i = buckets.length - 1; i >= 0 ; i--) {
            if(idx >= k) break;
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        return res;
    }
}
