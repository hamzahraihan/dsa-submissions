class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create an adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>(); 
        for(int[] time : times){
            adj.put(time[0], new ArrayList<>());
        }
        for(int[] time : times){
            // each starting node, insert next node, and time
            adj.get(time[0]).add(new int[]{time[1], time[2]}); // time[0] == starting node, time[1] == target node, time[2] == time
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // start from a node k (node that we will send a signal from)
        minHeap.offer(new int[]{0,k});

        // keep track of visited node, prevent visiting node twice
        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            // w1 = time it takes for all n nodes receive the signal, n1 = current node 
            int w1 = curr[0], n1 = curr[1];
            // if we already visited n1, skip the node
            if(visited.contains(n1)){
                continue;
            }
            // track visited node
            visited.add(n1);

            t = w1;
            if(adj.containsKey(n1)){
                // search neighboar of n1
                for(int[] next : adj.get(n1)){
                    int n2 = next[0], w2 = next[1]; // n2 == target node, w2 == target time
                    if(!visited.contains(n2)){
                        minHeap.offer(new int[]{w1 + w2, n2}); // store total time and target node;
                    }
                }
            }
        }
        // if we already visit all node, return the time
        return visited.size() == n ? t : -1;
    }
}
