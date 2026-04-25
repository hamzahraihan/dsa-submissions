class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            } else if (nums[mid] > nums[r]){
                l = mid + 1;
            }
        }
        return nums[l];
    }
}

/*
Intuisi:
gunakan algoritma binary search untuk mencari nilai paling rendah dari array
buat dua index kanan dan kiri lalu cari index tengah  
cek apakah nilai tengah lebih tinggi dari index kanan
jika lebih tinggi maka ubah posisi index kanan menjadi index tengah
*/

/* 
buat pointer kiri dan kanan (l dan r)
loop menggunakan while dengan kondisi l kurang dari r agar l tidak melewati r
ambil index tengah dari array dengan cara l tambah r bagi 2 
jika index tengah memiliki nilai lebih rendah dari index r, maka ubah posisi r ke posisi tengah
jika index tengah memiliki nilai lebih tinggi dari index r, maka ubah posisi l ke posisi tengah

*/