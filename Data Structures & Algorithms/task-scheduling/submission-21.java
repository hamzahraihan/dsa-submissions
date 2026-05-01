class Solution {
    public int leastInterval(char[] tasks, int n) {
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
            int maxIndex = -1;
            for(int i = 0; i < arr.size(); i++){
                boolean ok = true;
                for(int j = Math.max(0, time - n); j < time; j++){
                    if(j < processed.size() && processed.get(j) == arr.get(i)[1]){
                        ok = !ok;
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
