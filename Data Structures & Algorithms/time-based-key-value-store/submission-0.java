class TimeMap {
    private Map<String, TreeMap<Integer, String>> dict; 
    public TimeMap() {
        dict = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        dict.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!dict.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = dict.get(key);
        Map.Entry<Integer,String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
