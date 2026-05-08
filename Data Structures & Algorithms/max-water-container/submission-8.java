class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxA = -1;
        while(l < r){
            // pada setiap loop kita lakukan perhitungan area
            int area = (r - l) * Math.min(heights[l], heights[r]);
            maxA = Math.max(maxA, area);

            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxA;
    }
}

// intuisi
/* 
lakukan pengecekan menggunakan two pointer untuk melihat mana yang lebih tinggi
anggap input array berisikan panjang sebuah tembok
kita cari mana tembok yang paling tinggi, kita bisa mulai cari dari dua sisi yaitu kanan dan kiri
pada setiap loop kita hitung area pada lingkup dari tembok kanan dan kiri
jika tembok kiri lebih rendah dari tembok kanan kita geser ke tembok berikutnya
*/

// algoritma
/* 
- buatkan pointer kiri dan kanan
- buat variable untuk menyimpan area paling luas
- pada setiap loop kita hitung areanya menggunakan rumus
(kanan - kiri) * nilai paling rendah antara tembok kanan dan kiri
- buat kondisi jika tembok kiri lebih rendah dari tembok kanan
 maka kita bisa geser pointer kiri ke tembok berikutnya
- jika kondisi tembok kanan lebih tinggi dari tembok kiri kita bisa geser pointer kanan ke tembok berikutnya
*/