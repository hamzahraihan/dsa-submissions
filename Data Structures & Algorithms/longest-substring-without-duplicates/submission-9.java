class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0;
        int length = 0;
        for(int r = 0; r < s.length() ; r++){
            while(seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            System.out.println(seen);
            length = Math.max(length, r - l + 1);
        }
        return length;
    }
}

// cari simpan dari huruf-huruf yang sudah ditemukan sebelumnya.
// jika ada huruf yang sama dengan huruf sebelumnya maka terjadi duplikasi
// hapus satu huruf yang sama lalu simpan huruf baru
// ulangi langkah tersebut hingga mendapatkan substring tanpa huruf duplikasi


/* 
buatkan hashmap atau hashset untuk extra space O(n) sebagai tempat menyimpan huruf yang sudah ditemukan
buatkan variable L  dan R untuk membuat sebuah "windows" yang nantinya bisa digunakan untuk perhitungan panjang susbtring
lakukan perulangan pada string s dengan cara R < s.length()
lalu cek hashset, apakah ada huruf yang sudah ditemukan
jika ada, maka huruf tersebut perlu dihapus dari hashset lalu gantikan dengan huruf baru dan geser "windows" tersebut dengan cara ubah letak L menjadi R
dan R akan terus maju
setiap perulangan lakukan perhitungan pada panjang substring dengan menghitung index R kurangi dengan index L ditambah 1  


time complexity = O(n) untuk n adalah panjang string s
space complexity = O(n) untuk n adalah extra space menyimpan string s
*/