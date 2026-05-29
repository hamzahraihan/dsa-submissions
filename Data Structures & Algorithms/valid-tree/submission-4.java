class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});
        visited.add(0);

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];
            visited.add(node);
            for(int nb : adj.get(node)){
                if(visited.contains(nb) && nb != parent){
                    return false;
                }  
                if(!visited.contains(nb)){
                    q.offer(new int[]{nb, node});
                }
            }
        }
        return visited.size() == n;
    }
}
