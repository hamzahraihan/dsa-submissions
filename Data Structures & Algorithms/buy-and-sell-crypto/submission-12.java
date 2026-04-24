class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1; 
        int maxProfit = 0;
        while(r < prices.length){
            if(prices[r] > prices[l]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            }else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }
}

// cari stock dengan harga paling rendah lalu jual dengan harga tertinggi
// misalnya hari ke 0 harga mahal, lalu cek besok harga murah. maka beli di hari dimana stock harga murah
// simpan stock di variabel untuk nanti dijual di lain hari
// 
// jual di harga lebih tinggi untuk mendapatkan profit

// loop array prices untuk lihat hari dimana harga stock lebih murah.
// lalu cek apakah hari 0 lebih murah dari hari esok
// jika murah maka kurangi dengan harga stock hari esok 
// jika mahal maka buat variable L dan R bergeser satu langkah
// dengan cara jika prices[l] lebih mahal dari prices[r] maka geser variable L menjadi nilai R
// dan variable R ditambah 1
// namun jika prices[l] lebih murah dari prices[r] maka prices[r] kurangi prices[l] lalu simpan hasil di variable max profit
// setelah di kalkulasikan, variable R tetap bergerak untuk mencari kemungkinan hari stock lebih mahal dari sebelumnya
// gunakan algoritma sliding windows untuk mengecek input dari pada array prices;
// profit = 5 (prices[7]) - 1 (prices[1]) = 4
// profit = 6 (prices[7]) - 1 (prices[1]) = 5
// profit = 7 (prices[7]) - 1 (prices[1]) = 6
// simpan maksimal pada variabel max profit;
// max profit = 7;
// return max profit
