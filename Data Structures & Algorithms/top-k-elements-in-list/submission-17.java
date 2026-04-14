class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        List<int[]> arrList = new ArrayList<>();
        for(int key : count.keySet()){
            int freq = count.get(key);
            arrList.add(new int[] {freq, key});
        }
        arrList.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k]; 
        for(int i = 0; i < k; i++){
            res[i] = arrList.get(i)[1];
        }
        return res;
    }
}
