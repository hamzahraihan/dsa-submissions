class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] count = new int[26];
            for(Character ch: strs[i].toCharArray()){
                count[ch - 'a']++;
            }
            System.out.println(res);
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(strs[i]);
        }
        return new ArrayList<>(res.values());
    }
}
