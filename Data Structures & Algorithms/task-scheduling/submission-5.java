class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int i = 0; i < tasks.length; i++){
            count[tasks[i] - 'A']++;
        }

        // create a list with pair of a remaining count and task id  
        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                arr.add(new int[]{count[i], i});
            }
        }

        int time = 0;
        List<Integer> processed = new ArrayList<>();
        while(!arr.isEmpty()){
            int best_task_index = -1;
            for(int i = 0; i < arr.size(); i++){
                boolean ok = true;
                for(int j = Math.max(0, time - n); j < time; j++){
                    if(j < processed.size() && processed.get(j) == arr.get(i)[1]){
                        ok = false;
                        break;
                    }
                }
                if(!ok) continue;
                if(best_task_index == -1 || arr.get(i)[0] > arr.get(best_task_index)[0]){
                    best_task_index = i;
                }
            }

            time++;
            int curr = -1;
            if(best_task_index != -1){
                curr = arr.get(best_task_index)[1];
                arr.get(best_task_index)[0]--;
                if(arr.get(best_task_index)[0] == 0){
                    arr.remove(best_task_index);
                }
            }
            processed.add(curr);
        }
        return time;
    }
}
