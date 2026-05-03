class Solution {
    public int maxProfit(int[] prices) {
        // simpan nilai l
        int l = 0;
        // simpan nilai profit
        int maxProfit = 0;
        
        for(int r = 0; r < prices.length; r++){
            // jika harga jual lebih murah dari harga beli maka hitung profit dan simpan di variable maxProfit 
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else { // jika menemukan harga lebih murah maka geser index l menjadi r
                l = r;
            }
        }

        return maxProfit;
    }
}
// intuisi
/* 
beli stock di index harga paling murah, lalu jual di index harga paling mahal
buat dua pointer untuk meletakkan index harga paling murah
cari index dimana harga stock paling tinggi
*/

// algoritma
/* 
- buat dua pointer, left dan right 
- pointer left untuk index harga murah
- pointer right untuk mencari index harga paling tinggi
- jika pointer right menemukan harga lebih murah maka geser pointer left ke pointer right
- jika menemukan harga paling tinggi maka jual untuk mencari keuntungan
- hitung keuntungan dengan cara harga beli - harga jual
- jika mendapatkan keuntungan maksimal maka simpan keuntungan tersebut pada variable maxProfit
- jika pointer right mencapai akhir dari array maka kembalikan nilai maxProfit
*/