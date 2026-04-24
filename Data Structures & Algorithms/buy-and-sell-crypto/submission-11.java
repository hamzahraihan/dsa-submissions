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
// jual di harga lebih tinggi untuk mendapatkan profit

// profit = 5 (prices[7]) - 1 (prices[1]) = 4
// profit = 6 (prices[7]) - 1 (prices[1]) = 5
// profit = 7 (prices[7]) - 1 (prices[1]) = 6
// simpan maksimal pada variabel max profit;
// max profit = 7;
// return max profit
