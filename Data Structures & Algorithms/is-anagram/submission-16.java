class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> stringS = new HashMap<>();
        Map<Character,Integer> stringT = new HashMap<>();

        for(int i = 0; i < s.length();i++ ){
            stringS.put(s.charAt(i), stringS.getOrDefault(s.charAt(i),0) + 1);
            stringT.put(t.charAt(i), stringT.getOrDefault(t.charAt(i),0) + 1);
        }

        return stringS.equals(stringT);
    }
}
