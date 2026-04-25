class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int top = stack.pop(); 
        if(top == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// intuisi:
/* 
kita bisa menggunakan dua stack
satu stack untuk menyimpan seluruh input
satu stack untuk meyimpan input paling kecil
cara ini merupakan desain paling cocok untuk efisiensi waktu secara konstan O(1)
*/

/* 
buat stack dan minstack
lakukan push input pada kedua stack. untuk minstack, cek apakah value input lebih kecil dari value top dari minstack
jika lebih kecil maka push
lakukan pop atau hapus input paling atas dari kedua stack jika input stack dan minstack sama atau equal, jika tidak maka hapus di stack saja
fungsi top untuk melihat input paling atas dari stack 
fungsi getMin untuk melihat input paling atas dari minstack
*/