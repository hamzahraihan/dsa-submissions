class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int task: tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt : count){
            if(cnt > 0){
                maxHeap.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!q.isEmpty() || !maxHeap.isEmpty()){
            time++;
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            } else { 
                int cnt = maxHeap.poll() - 1;
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
