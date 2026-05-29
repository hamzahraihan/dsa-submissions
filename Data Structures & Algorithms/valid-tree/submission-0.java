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
        if(hasCycle(adj, 0, visited, -1)){
            return false;
        }

        for(boolean v : visited){
            if(!v) return false;
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int node, boolean[] visited, int parent){
        visited[node] = true;
        for(int nb : adj.get(node)){
            if(visited[nb] && parent != nb){
                return true;
            } else if (!visited[nb] && hasCycle(adj, nb, visited, node)) {
                return true;
            }
        }
        return false;
    }

}
