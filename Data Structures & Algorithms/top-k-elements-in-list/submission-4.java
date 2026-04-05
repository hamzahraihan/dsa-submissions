
// sorting solution O(n log n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashmap.containsKey(nums[i])){
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            }else {
                hashmap.put(nums[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>(hashmap.keySet());
        list.sort((a,b) -> hashmap.get(b) - hashmap.get(a));
        

        int[] res = new int[k];
        for(int i = 0; i < k;i++){
            res[i] = list.get(i);
        }
        
        return res;
    }
}
