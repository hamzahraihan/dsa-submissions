class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(hm.containsKey(complement)){
                return new int[] {hm.get(complement), i};
            }

            hm.put(nums[i], i);
        }

        return new int[0];
    }
}

/* 
Intuisi:
asumsi bahwa input pada array nums mempunyai satu pasang index i dan j untuk memenuhi kondisi target
untuk cek apakah index i dan j memenuhi target, kita bisa mencoba cek index i dan j dengan perulangan 2 kali.
atau lebih efisien jika kita cek menggunakan angka pelengkap.
untuk mendapatkan angka pelengkap bisa hitung dengan angka dari array nums[i] - target, lalu ambil indexnya angka pelengkapnya

cara yang paling efisien adalah dengan menggunakan extra space (hashmap) untuk menyimpan index dan nums[i]
*/

/*
buatkan hashmap untuk menyimpan nums[i] sebagai key, dan index sebagai value
buatkan perulangan untuk array nums
hitung angka pelengkap dengan cara nums[i] - target;
cek apakah angka pelengkap ada di hashmap
jika angka pelengkap ada di hashmap, maka kembalikan array dengan input index dari nums[i] dan index dari angka pelengkap di hashmap
simpan seluruh angka dan indexnya pada hashmap
jika angka pelengkap tidak ada di hashmap maka kembalikan nilai dengan array kosong
*/