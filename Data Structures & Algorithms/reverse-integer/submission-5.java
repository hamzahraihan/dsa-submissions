class Solution {
    public int reverse(int x) {
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while(x != 0){
            int digit = x % 10;
            x = x / 10;
            if(res > max / 10 || res < min / 10){
                return 0;
            }
            res = res * 10 + digit;
        }

        return res;
    }
}

// intuisi
/*
membalikkan nomor tanpa menggunakan string bisa dengan menggunakan modulo (%)
ambil digit terakhir menggunakan modulo
lalu hilangkan angka terakhir menggunakan pembagian 10
jika angka melebihi 32bit integer maka kita langsung kembalikan nilai 0
 */

/* algoritma
- buatkan variable res untuk menyimpan nilai terakhir dari x
- ketika x bukan 0 atau masih memiliki nilai maka
    - ambil angka terakhir dengan membuat perhitungan x % 10
    - lalu hilangkan nilai terakhir dari x menggunakan x / 10
    - simpan angka dengan cara res * 10 + digit
- cek apakah res melampaui nilai 32bit integer dengan menggunakan Integer.MAX_VALUE untuk nilai max integer dan Integer.MIN_VALUE untuk nilai min integer
- jika melampaui maka kembalikan nilai 0
- kembalikan nilai res dengan narrow casting, yaitu mengubah tipe data long(64bit numbers) menjadi int(32bit)

*/