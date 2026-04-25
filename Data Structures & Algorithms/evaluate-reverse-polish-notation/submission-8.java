class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")){
                int top = stack.pop();
                stack.push(stack.pop() - top);
            }else if(tokens[i].equals("*")){
                int top = stack.pop();
                stack.push(stack.pop() * top);
            }else if(tokens[i].equals("/")){
                int top = stack.pop();
                stack.push(stack.pop() / top);
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}

// intuisi:
/* 
gunakan stack untuk meyimpan nomor
lakukan perulangan pada array tokens, jika menemukan integer maka simpan pada stack.
buat perkondisian untuk mengecek apakah input dari array tokens bukan tipe data integer
jika menemukan suatu kondisi yaitu input token berupa operator aritmatika maka, lakukan kalkulasi berdasarkan operator tersebut
*/

/*
buat stack
looping menggunakan for loop
simpan ke stack jika input bukan tipe data integer
lakukan kalkulasi dari dua input sebelumnya
simpan nilai pada stack jika selesai proses kalkulasi
jika proses sudah selesai atau perulangan sudah selesai maka kembalikan hasil kalkulasi 
kembalikan hasil menggunakan stack.peek()
 */