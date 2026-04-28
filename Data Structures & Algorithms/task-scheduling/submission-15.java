class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                maxHeap.add(count[i]);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int cnt = maxHeap.poll() - 1; 
                if(cnt > 0){
                    q.add(new int[]{cnt, time + n});
                }
            }else {
                time = q.peek()[1];
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}

/*
Intuisi:
kerjakan paling pertama tugas yang memiliki sisa lebih banyak, karena tugas tersebut yang paling sulit untuk dimasukkan ke jadwal 
(membutuhkan slot jarak cooldown)

jadi caranya:
- buat priority queue menjadi max-heap(akses untuk nilai paling tinggi) untuk tugas dengan sisa paling banyak 
- pada setiap waktu berjalan, kita ambil tugas dengan sisa paling banyak lalu jalankan
- setelah tugas selesai berjalan, tugas tersebut masuk kedalam antrian cooldown lalu menetapkan waktu pada
  tugas tersebut untuk bisa dikerjakan pada waktu tertentu(waktu saat ini + n)
- jika tugas cooldown selesai, kita masukkan ke dalam max heap supaya bisa dikerjakan pada jadwal tertentu
- jika max heap kosong, namun tugas masih ada tersisa atau sedang cooldown,
  maka kita bisa memajukan waktu saat ini ke depan ketika tugas tersedia untuk dikerjakan   
 */

/* 
algoritma:
1. hitung berapa banyak tugas pada array tasks
2. buat priority queue dengan max-heap (dengan nilai paling tinggi berada di atas / diprioritaskan)
3. buat queue / linkedlist pada java untuk menyimpan nilai pasangan(sisa tugas setelah dikerjakan, waktu tersedia untuk bisa dikerjakan kembali)
4. buat variable waktu = 0
5. jika priority queue tidak kosong, dan linkedlist tidak kosong
    - tambahkan nilai waktu dengan 1
    - jika priority queue tidak kosong:
        *ambil tugas dengan sisa paling banyak 
        *kerjakan: sisa tugas -= 1
        *jika sisa tugas > 0, maka simpan (sisa tugas, time + n) ke linkedlist(untuk dikerjakan kembali setelah n)
    - cek antrian cooldown paling depan
        * jika tugas yang sedang cooldown pada waktu n menemui waktu saat ini, maka hapus dari linkedlist dan masukkan sisa tugas kembali ke priority queue 
    - jika priority queue kosong dan linkedlist tidak kosong 
        *buat waktu menjadi waktu tersedia berikutnya
        *buat waktu menjadi waktu berikutnya untuk memajukan waktu lebih cepat
6. jika priority queue dan linkedlist kosong, maka kembalikan nilai sebagai waktu minimum untuk menyelesaikan tugas tugas keseluruhan
*/