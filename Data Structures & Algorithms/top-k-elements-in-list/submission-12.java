class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int num : nums){
            count.put(num, count.getOrDefault(num,0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : count.keySet()){
            int freq = count.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList();
            }

            bucket[freq].add(key);
        }
        for(List<Integer> b : bucket){
            System.out.println(b);
        }
        int[] result = new int[k];
        int idx = 0;
        for(int i = bucket.length - 1 ; i >= 0; i--){
            if(idx == k)break;
            if(bucket[i] == null)continue;
            for(int num : bucket[i]){
                result[idx] = num;
                idx++;
                if(idx == k)break;
            }
        }
        return result;
    }
}
