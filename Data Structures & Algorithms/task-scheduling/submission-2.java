class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char ch : tasks){
            count[ch - 'A']++;
        }

        List<int[]> task_with_id  = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                task_with_id.add(new int[] {count[i], i});
            }
        }

        int time = 0;
        List<Integer> processed = new ArrayList<>();
        while(!task_with_id.isEmpty()){
            int best_task_index = -1;
            for(int i = 0; i < task_with_id.size(); i++){
                boolean ok = true;
                for(int j = Math.max(0, time - n); j < time; j++){
                    if(j < processed.size() && processed.get(j) == task_with_id.get(i)[1]){
                        ok = false;
                        break;
                    }
                }
                if(!ok) continue;
                if(best_task_index == -1 || task_with_id.get(best_task_index)[0] < task_with_id.get(i)[0]){
                    best_task_index = i;
                }
            }

            time++;
            int curr = -1;
            if(best_task_index != -1){
                curr = task_with_id.get(best_task_index)[1];
                task_with_id.get(best_task_index)[0]--;
                if(task_with_id.get(best_task_index)[0] == 0){
                    task_with_id.remove(best_task_index);
                }
            }
            processed.add(curr);
        }
        return time;
    }
}
