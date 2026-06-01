class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char ch : tasks){
            count[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                maxHeap.offer(count[i]);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0){
                    q.offer(new int[]{cnt, time + n});
                }
            } else {
                time = q.peek()[1];
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
