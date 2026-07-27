class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // number, count
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int num : count.keySet()){
            int cnt = count.get(num);
            if(buckets[cnt] == null){
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(num);
        }

        int[] res = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0 && idx < k; i--){
            if(buckets[i] == null) continue;
            for(int num : buckets[i]){
                res[idx++] = num;
            }
        }
        return res;
    }
}

// algoritma
/* 
1. buatkan hashmap untuk menyimpan jumlah nilai array
2. gunakan perulangan untuk iterasi array nums, jika ada nilai yang sama maka tambahkan nilai jumlahnya
3. buatkan array 2 dimensi untuk menyimpan nilai sesuai jumlahnya
4. lakukan perulangan untuk menyimpan nilai dari hashmap ke array 2 dimensi 
5. buatkan array  untuk nantinya kita return sebagai hasil
6. lakukan perulangan untuk mencari nilai dengan frekuensi terbanyak menurut K
7. kembalikan array yang menyimpan nilai terbanyak sebagai hasil 
*/