class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); 
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int num : count.keySet()){
            int cnt = count.get(num);
            minHeap.offer(new int[]{cnt, num});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll()[1];
        }
        return res;
    }
}
