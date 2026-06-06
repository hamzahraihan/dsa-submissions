class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time : times){
            adj.put(time[0], new ArrayList<>());
        }

        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while(!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            int w1 = node[0], n1 = node[1]; // weight of current node, starting node
            if(visited.contains(n1)){
                continue;
            }
            visited.add(n1);
            t = w1;
            if(adj.containsKey(n1)){
                for(int[] next : adj.get(n1)){
                    int n2 = next[0], w2 = next[1]; // target node and weight of next node
                    if(!visited.contains(n2)){
                        minHeap.offer(new int[]{w1 + w2, n2});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
