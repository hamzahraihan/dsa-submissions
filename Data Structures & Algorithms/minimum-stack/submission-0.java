class MinStack {
    List<Integer> list;

    public MinStack() {
        this.list = new ArrayList<>();
    }
    
    public void push(int val) {
        this.list.add(val);
    }
    
    public void pop() {
        this.list.remove(this.list.size() - 1);
    }
    
    public int top() {
        return this.list.get(this.list.size() - 1);
    }
    
    public int getMin() {
        int min = this.list.get(this.list.size() - 1);
        for(int val : this.list){
            min = Math.min(min, val);
        }
        return min;
    }
}
