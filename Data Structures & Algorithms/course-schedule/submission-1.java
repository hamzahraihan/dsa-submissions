class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] prereq : prerequisites){
            int dest = prereq[0];
            int src = prereq[1];
            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            indegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int nb : graph.getOrDefault(course, new ArrayList<>())){
                indegree[nb]--;
                if(indegree[nb] == 0){
                    q.offer(nb);
                }
            }
        }
        return count == numCourses;
    }
}
