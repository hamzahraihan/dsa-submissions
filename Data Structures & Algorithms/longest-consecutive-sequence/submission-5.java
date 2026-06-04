class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int n : nums){
            seen.add(n);
        }
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            seen.add(nums[i]);
            if(!seen.contains(nums[i] - 1)){
                int length = 1;
                while(seen.contains(nums[i] + length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
