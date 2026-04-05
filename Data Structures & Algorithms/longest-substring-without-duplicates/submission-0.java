class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int start = 0;
        int longestSub = 0;
        for(int end = 0; end < s.length(); end++){
            while(seen.contains(s.charAt(end))){
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(s.charAt(end));
            longestSub = Math.max(longestSub,end - start + 1);
        }
        System.out.println(seen);
        return longestSub;
    }
}
