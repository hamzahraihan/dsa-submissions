class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] anagram = new int[26];
        for(int i = 0; i < s.length(); i++){
            anagram[s.charAt(i) - 'a']++;
            anagram[t.charAt(i) - 'a']--;
        }

        for(int n : anagram){
            if(n == 0) continue;
            if(n != 0) return false;
        }
        return true;
    }
}
