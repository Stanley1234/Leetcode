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
     public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0) return ans;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start)
                    return o2.end - o1.end;
                return o1.start - o2.start;
            }
        });

        Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(int i = 1;i < intervals.size();i ++) {
            Interval next = intervals.get(i);
            if(next.start > cur.end) {
                ans.add(cur);
                cur = next;
            } else if(cur.start <= next.start && next.start <= cur.end
                    && next.end > cur.end) {
                cur.end = next.end;
            }
        }
        ans.add(cur);
        return ans;
    }
}