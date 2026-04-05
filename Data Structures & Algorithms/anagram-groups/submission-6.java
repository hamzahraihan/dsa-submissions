class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(int i = 0; i < strs.length;i++){
            int[] count = new int[26];
            for(Character ch : strs[i].toCharArray()){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
