class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            // jika tidak ada duplikasi pada jangkauan window maka geser window
            if(r - l > k){
                window.remove(nums[l]);
                l++;
            }
            // cek apakah terdapat nilai duplikasi pada jangkauan window
            if(window.contains(nums[r])){
                return true;
            }
            // setiap loop, masukkan nums[r] pada hashset
            window.add(nums[r]);
        }
        return false;
    }
}


// intuisi
/*
untuk mencari angka duplikasi diantara index k, kita bisa menggunakan cara sliding window dan hashset
masukkan angka kedalam hashset setiap selesai loop array nums
buatkan window dengan ukuran k, cari angka pada jangkauan window
jika angka pada window tidak memiliki duplikasi maka geser window 
jika terdapat angka duplikasi maka kembalikan nilai true
 */

// algoritma
/* 
- buat dataset menggunakan hashset
- buat index l untuk titik awal window
- buat loop untuk mencari nilai duplikasi
- pada setiap loop masukkan angka kedalam dataset
- jika tidak ada duplikasi di dalam jangkauan window, maka geser window dan hapus nilai hashset pada index l 
- cek apakah terdapat nilai duplikasi di dalam hashset
- kembalikan true jika terdapat duplikasi
- jika tidak maka kembalikan false;
*/