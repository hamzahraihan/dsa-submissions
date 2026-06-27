class TimeMap {
    private Map<String, List<Pair<Integer, String>>> dict;
    public TimeMap() {
        this.dict = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        dict.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp,  value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values = dict.getOrDefault(key, new ArrayList<>());
        int l = 0, r = values.size();
        String res = "";
        while(l < r){
            int mid = l + (r - l) / 2;
            if(values.get(mid).getKey() <= timestamp) { 
                res = values.get(mid).getValue();
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return res;
    }
}
