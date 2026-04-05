class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> sCounter = new HashMap<>();
        HashMap<Character, Integer> tCounter = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            sCounter.put(s.charAt(i),sCounter.getOrDefault(s.charAt(i),0) + 1);
            tCounter.put(t.charAt(i),tCounter.getOrDefault(t.charAt(i),0) + 1);
        }
        return sCounter.equals(tCounter);
    }
}
