class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for(int key : count.keySet()){
            int val = count.get(key);
            arr.add(new int[] {val, key});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}
