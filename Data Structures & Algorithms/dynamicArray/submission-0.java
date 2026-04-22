class DynamicArray {
    private int[] array;
    private int capacity;
    private int length; 

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.array = new int[this.capacity];
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if(this.length == this.capacity){
            resize();
        }
        this.array[length] = n;
        length++;
    }

    public int popback() {
        if(length > 0){
            length--;
        }
        return this.array[length];
    }

    private void resize() {
        this.capacity *= 2;
        int[] newArray = new int[this.capacity];
        for(int i = 0 ; i < this.length; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
