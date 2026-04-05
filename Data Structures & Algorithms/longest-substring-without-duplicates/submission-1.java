class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int start = 0;
        int longest = 0;
        for(int end = 0; end < s.length();end++){
            while(seen.contains(s.charAt(end))){
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(s.charAt(end));
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }
}
