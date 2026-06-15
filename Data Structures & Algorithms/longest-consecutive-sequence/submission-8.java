class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            seen.add(num);
        }
        int longest = 0;
        for(int num : seen){
            int length = 1;
            while(seen.contains(num + length)){
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
