class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int key : count.keySet()){
            int val = count.get(key);
            heap.offer(new int[]{val, key});
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] res = new int[k];
        for(int i = heap.size() - 1; i >= 0; i--){
            res[i] = heap.poll()[1];
        }
        return res;
    }
}
