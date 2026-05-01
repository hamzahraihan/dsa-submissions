class Solution {
    public int leastInterval(char[] tasks, int n) {
        // hitung jumlah masing masing tugas
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        // masukkan tugas tugas yang tersisa, dan gunakan index sebagai task id
        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                arr.add(new int[]{count[i], i});
            }
        }

        int time = 0;
        // list processed untuk menyimpan tugas yang sudah diselesaikan
        List<Integer> processed = new ArrayList<>();
        while(!arr.isEmpty()){
            // variable index yang digunakan untuk menandai dengan task terbanyak
            int maxi = -1;
            for(int i = 0; i < arr.size(); i++){
                // apakah tugas tersedia untuk dikerjakan
                boolean ok = true;
                // cek apakah tugas belum dikerjakan dalam kurun waktu n
                for(int j = Math.max(0, time - n); j < time; j++){
                    // jika sudah dikerjakan maka skip tugas dengan task id yang berada di processed
                    if(j < processed.size() && processed.get(j) == arr.get(i)[1]){
                        ok = false;
                        break;
                    }
                }
                if(!ok)continue;
                // jika belum maka kerjakan tugasnya
                if(maxi == -1 || arr.get(i)[0] > arr.get(maxi)[0]){
                    maxi = i;
                }
            }
            time++;
            int curr = -1;
            // jika tugas index sudah dikerjakan maka
            if(maxi != -1){
                curr = arr.get(maxi)[1];
                // kurangi tugas tersebut
                arr.get(maxi)[0]--;
                // lalu jika tugas sudah habis maka hapus dari antrian tugas
                if(arr.get(maxi)[0] == 0){
                    arr.remove(maxi);
                }
            }
            // masukkan tugas kedalam list processed
            processed.add(curr);
        }
        return time;
    }
}
