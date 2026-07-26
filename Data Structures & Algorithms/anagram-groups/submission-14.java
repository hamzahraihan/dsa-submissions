class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] key = new int[26];
            for(char ch : str.toCharArray()){
                key[ch - 'a']++;
            }
            String stringKey = Arrays.toString(key);
            map.computeIfAbsent(stringKey,k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
