class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> list = new HashMap<>();
        for(int i = 0; i < strs.length; i++){ // runs m times
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String keys = new String(chars);
            
            if(!list.containsKey(keys)){
                list.put(keys,new ArrayList<>());
            }
            list.get(keys).add(s);
        }
        return new ArrayList<>(list.values());
    }
}