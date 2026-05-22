class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            indegree[prereq[1]]++;
            adj.get(prereq[0]).add(prereq[1]);
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
            for(int nb : adj.get(course)){
                indegree[nb]--;
                if(indegree[nb] == 0){
                    q.offer(nb);
                }
            }
        }
        return count == numCourses;
    }
}
