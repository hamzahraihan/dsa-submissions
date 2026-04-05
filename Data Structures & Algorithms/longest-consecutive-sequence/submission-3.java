class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> seen = new HashSet<>();

        for(int n : nums ){
            seen.add(n);
        }

        for(int n : nums){
            int streak = 0, curr =  n;
            while(seen.contains(curr)){
                streak++;
                curr++;
            }
            result = Math.max(result,streak);
        }
        return result;
    }
}
