/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        // [1, 3], [1, 7]  remove [1, 7]
        // [1, 3], [2, 5]  remove [2, 5]
        if (intervals.length == 0) { return 0; }
        
        Comparator<Interval> comparator = (o1, o2) -> {
            
            return o1.end - o2.end;
        };
        Arrays.sort(intervals, comparator);

        int cnt = 0;
        int curRight = intervals[0].end;
        for (int i = 1;i < intervals.length;i ++) {
            if (intervals[i].start < curRight) {
                cnt ++;
            } else {
                curRight = intervals[i].end;
            }
        }
        return cnt;
    }
}