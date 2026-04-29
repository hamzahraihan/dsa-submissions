class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26]; 
        for(char task : tasks){
            count[task - 'A']++;
        }

        // put all task in maxHeap to easily get the most freqeuent tasks
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                maxHeap.add(count[i]);
            }
        }

        // store time required to complete all tasks
        int time = 0;
        // store task that remain cooldown for n time
        // store pair of task remaining count, and cooldown time 
        Queue<int[]> q = new LinkedList();
        // while maxHeap or q is not empty, keep doing a cycle until both are empty
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            // each loop increase time
            time++;
            // decrease task each time increase;
            if(!maxHeap.isEmpty()){
                int cnt = maxHeap.poll() - 1;
                // store to q every time each task is done;
                if(cnt > 0){
                    q.add(new int[]{cnt, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
