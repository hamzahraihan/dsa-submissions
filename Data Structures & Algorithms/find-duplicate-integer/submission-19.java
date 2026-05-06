class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // low dan high untuk jarak antara nilai rendah dan tinggi
        int low = 1, high = n - 1;
        while(low < high){
            int mid = (low + high) / 2;
            int count = 0;
            for(int i = 0; i < nums.length ; i++){
                // cek apakah nilai nums[i] (1) <= mid (3)
                if(nums[i] <= mid){
                    count++;
                }
            }

            // cek jika terdapat total angka berjumlah dibawah atau sama dengan mid, maka ubah nilai paling rendah menjadi nilai mid + 1
            if(count <= mid){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

// intuisi
/* 
menggunakan cara binary search untuk nilai duplikasi
ambil nilai tengah lalu hitung berapa banyak angka yang dibawah atau sama dengan nilai tengah
jika total angka lebih banyak dari nilai tengah maka ada indikasi bahwa nilai duplikasi terdapat di antara nilai tengah dan nilai paling tinggi
*/

// algoritma
/* 
- buat variable dengan nilai paling rendah, dan variable dengan nilai paling tinggi
- lakukan perulangan dengan kondisi nilai rendah < nilai paling tinggi
- ambil nilai paling tengah = (low + high) / o
- buat variable count untuk menghitung angka yang lebih rendah atau sama dengan nilai tengah
- buat perulangan pada array nums
- buat kondisi apakah nilai nums[i] lebih rendah atau sama dengan nilai tengah
- jika kondisi sesuai, maka tambah variable count dengan 1  
- lalu buatkan kondisi jika count <= mid, maka geser nilai low menjadi mid + 1
- jika count > mid, maka geser nilai high menjadi mid
*/