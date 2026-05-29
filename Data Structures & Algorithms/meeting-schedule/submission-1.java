/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for(int i = 0; i < intervals.size() - 1; i++){
            Interval A = intervals.get(i);
            Interval B = intervals.get(i + 1);

            if(A.end > B.start){
                return false;
            }
        }
        return true;
    }
}
