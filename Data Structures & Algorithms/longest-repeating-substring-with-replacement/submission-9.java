class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, maxF = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, count.getOrDefault(s.charAt(r), 0));
            while((r - l + 1) - maxF > k){
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

/* 
Intuisi
cari karakter dari string S, jika terdapat karakter yang berbeda, maka
hitung panjang karakter tersebut sebelum ganti ke karakter yang baru, lalu cari lagi karakter yang berulang hingga mendapatkan
karakter berulang terpanjang. 
Kita diberikan kesempatan untuk mengganti karakter sebanyak 'k'
karena hanya bisa ubah huruf sebanyak 'k' maka 
kita hitung karakter yang berada di index kiri sampai index kanan, lalu kurangi dengan total karakter yang sama,
jika hasil mencapai lebih dari 'k' maka kurangi total karakter tersebut dan simpan di variable result atau hasil
*/

/*
gunakan hashmap atau array (ascii) untuk menghitung banyak masing masing karakter
cari karakter yang sama pada string s 
simpan karakter jika belum ada di hashmap, hitung jumlah karakter jika karakter sudah ada di hashmap
simpan total karakter tertinggi di variable 'max_freq'
gunakan algoritma sliding window untuk melihat substring dengan karakter yang sama
lalu hitung ukuran 'window' dan kurangi dengan 'max_freq' untuk cek apakah terdapat perubahan yang melebihi 'k'
hitung dengan cara index R - index L + 1 - max_freq jika melebihi 'k', maka kurangi total karakter dan geser index L kedepan
untuk mendapatkan hasil karakter berulang, hitung panjang substring
*/