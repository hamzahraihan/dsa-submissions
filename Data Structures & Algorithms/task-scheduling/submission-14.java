class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                arr.add(new int[] {count[i], i});
            }
        }

        int time = 0; 
        List<Integer> processed = new ArrayList<>();
        while(!arr.isEmpty()){
            int maxIndex = -1; 
            for(int i = 0; i < arr.size(); i++){
                boolean ok = true;
                for(int j = Math.max(0, time - n); j < time; j++){
                    if(j < processed.size() && processed.get(j) == arr.get(i)[1]){
                        ok = false;
                        break;
                    }
                }
                if(!ok) continue;
                if(maxIndex == -1 || arr.get(i)[0] > arr.get(maxIndex)[0]){
                    maxIndex = i;
                }
            }

            time++;
            int curr = -1;
            if(maxIndex != -1){
                curr = arr.get(maxIndex)[1];
                arr.get(maxIndex)[0]--;
                if(arr.get(maxIndex)[0] == 0){
                    arr.remove(maxIndex);
                }
            }
            processed.add(curr);
        }
        return time;
    }
}
/* 
Intuisi:
setiap siklus CPU, CPU bisa mengerjakan satu tugas, dan tugas tugas tersebut bisa di selesaikan tanpa harus berurutan  
satu satunya yang menjadi batasan adalah setiap tugas tugas yang identik wajib dipisahkan setidaknya 'N' siklus CPU untuk CPU istirahat.

untuk menyelesaikan permasahalan tersebut, kita bisa mensimulasikan CPU sekali dalam satu waktu.
dari setiap langkah, kita lihat tugas tugas yang tersisa.
ambil tugas yang tidak sedang cooldown (tidak di kerjakan dalam n waktu terakhir).
dari tugas tugas tersebut, ambil tugas yang memiliki banyak tugas tersisa 

jika tidak ada tugas yang tersedia, CPU akan istirahat dalam beberpa waktu.
kita ulangi langkah sebelumnya hingga tugas terselesaikan seluruhnya.
*/

/* 
algoritma:
-hitung berapa banyak masing masing tugas yang tersedia. 
-buat list dengan array yang mempunyai nilai {sisa tugas, id tugas}, untuk semua tugas yang masih tersisa (sisa_tugas > 0)
-kelola waktu = 0 (total waktu pengerjaan), variable list processed untuk menyimpan tugas yang sudah di proses sebelumnya
-jika masih ada tugas di list
    *buat variable best_task_index = -1 (untuk menandakan task yang sedang cooldown atau sudah dikerjakan sebelumnya)
    *cek apakah tugas belum dikerjakan dalam waktu 'N' (yaitu, tugas dengan id tertentu tidak dikerjakan pada waktu processed.get(max(0, time - n)) .. waktu - 1)
    *jika bisa dikerjakan maka, jika best_task_index == -1 atau sisa tugas index 'i' lebih besar dari sisa tugas yang sedang idle sebelumny, maka ubah best_task_index menjadi index 'i'
-naikkan waktu pengerjaan sebanyak 1
-cek jika best_task_index != -1:
    *maka eksekusi tugas dalam waktu saat ini:
        *kurangi sisa tugas sebanyak 1
        *jika sisa tugas menjadi 0 maka hapus dari list
        *masukkan id task ke list processed, 
    *jika tidak ada tugas yang bisa di eksekusi/sedang cooldown maka:
        masukkan penanda idle (-1) ke list processed
-ketika list tugas menjadi kosong, maka kembalikan nilai waktu sebagai total minimal waktu yang diperlukan
*/
