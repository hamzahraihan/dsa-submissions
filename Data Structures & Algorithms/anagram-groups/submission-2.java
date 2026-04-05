class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>(); 
        
        for(String s : strs){
            int[] count = new int[26];
            for(Character c: s.toCharArray()){
                count[c - 'a']++;
            }
           StringBuilder sb = new StringBuilder();
           for(int i : count){
               sb.append('#').append(i);
           }
           String key = sb.toString();
           if(!res.containsKey(key)){
                res.put(key, new ArrayList<>());
           }
           res.get(key).add(s);
        }
        System.out.println(res);
        return new ArrayList<>(res.values());
    }
}
