class Solution {
    public int leastInterval(char[] tasks, int n) {
        // hitung jumlah masing masing tugas
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                arr.add(new int[]{count[i], i});
            }
        }

        int time = 0;
        List<Integer> processed = new ArrayList<>();
        while(!arr.isEmpty()){
            int maxi = -1;
            for(int i = 0; i < arr.size(); i++){
                boolean ok = true;
                for(int j = Math.max(0, time - n); j < time; j++){
                    if(j < processed.size() && processed.get(j) == arr.get(i)[1]){
                        ok = false;
                        break;
                    }
                }
                if(!ok)continue;
                if(maxi == -1 || arr.get(i)[0] > arr.get(maxi)[0]){
                    maxi = i;
                }
            }
            time++;
            int curr = -1;
            if(maxi != -1){
                curr = arr.get(maxi)[1];
                arr.get(maxi)[0]--;
                if(arr.get(maxi)[0] == 0){
                    arr.remove(maxi);
                }
            }
            processed.add(curr);
        }
        return time;
    }
}
