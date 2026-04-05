class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet();
        int longest = 0;
        for(int n: nums){
            numSet.add(n);
        }
        for(int n: numSet){
            if(!numSet.contains(n - 1)){
                int length = 1;
                while(numSet.contains(n + length)){
                    length += 1;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest; 
    }
}
