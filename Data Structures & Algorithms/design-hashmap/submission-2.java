class ListNode { 
    public int key;
    public int val;
    public ListNode next;


    public ListNode(int key, int val, ListNode next){
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public ListNode(){
        this.key = 0;
        this.val = 0;
        this.next = null;
    }
}

class MyHashMap {
    private ListNode[] map;
    
    public MyHashMap() {
        map = new ListNode[1000];
        for(int i = 0; i < 1000; i++){
            map[i] = new ListNode();
        }
    }

    private int hash(int key){
        return key % map.length;
    }
    
    public void put(int key, int value) {
        ListNode node = map[hash(key)];
        while(node.next != null){
            if(node.next.key == key){
                node.next.val = value;
                return;
            }
            node = node.next;
        }
        node.next = new ListNode(key,value,null);
    }
    
    public int get(int key) {
        ListNode node = map[hash(key)].next;
        while(node != null){
            if(node.key == key){
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode node = map[hash(key)];
        while(node.next != null){
            if(node.next.key == key){
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */