class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> store = new HashSet<>();

        for(int num : nums){
            store.add(num);
        }

        for(int num : nums){
            if(!store.contains(num - 1)){
                int streak = 1;
                while(store.contains(num + streak)){
                    streak++;
                }
                res = Math.max(res, streak);
            }
        }
        return res;
    }
}
