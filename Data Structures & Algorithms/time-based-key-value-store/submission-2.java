class TimeMap {
    private Map<String, List<Pair<Integer,String>>> dict; 
    public TimeMap() {
        dict = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        dict.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = dict.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size();
        String res = "";
        while(left < right){
            int mid = (left + right) / 2;
            if(values.get(mid).getKey() <= timestamp){
                res = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return res;
    }
}
