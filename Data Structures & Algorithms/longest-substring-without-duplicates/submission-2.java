class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int start = 0;
        int longest = 0;
        for(int end = 0; end < s.length(); end++){
            while(charSet.contains(s.charAt(end))){
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(end));
            longest = Math.max(longest,end - start + 1);
        }
        return longest;
    }
}
