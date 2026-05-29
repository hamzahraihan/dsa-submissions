class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            merged.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        merged.add(newInterval);
        for(int j = i; j < n; j++){
            merged.add(intervals[j]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
