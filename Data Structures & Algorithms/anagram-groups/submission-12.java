class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for(String str : strs){
            int[] key = new int[26];
            for(char ch : str.toCharArray()){
                key[ch - 'a']++;
            }
            String stringKey = Arrays.toString(key);
            res.putIfAbsent(stringKey, new ArrayList());
            res.get(stringKey).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
