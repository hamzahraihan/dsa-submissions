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

        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,-1});

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1]; 
            for(int nb : adj.get(node)){
                if(nb == parent){
                    continue;
                }
                if(visited[nb]){
                    return false;
                }
                visited[nb] = true;
                q.offer(new int[]{nb, node});
            }
        }


        for(boolean v : visited){
            if(!v) return false;
        }

        return true;
    }
}
