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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        Collections.sort(intervals, (a,b) ->
        {
            if(a.start == b.start) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });
        int room = 1;
        TreeSet<Integer> prevEnds = new TreeSet<>();
        prevEnds.add(intervals.get(0).end);
        for(int i=1; i< intervals.size(); i++)
        {
                if(!prevEnds.isEmpty() && prevEnds.first() <= intervals.get(i).start)
                {
                    prevEnds.pollFirst();
                }else
                {
                    room++;
                }
                prevEnds.add(intervals.get(i).end);

            }   
              return room;
        }
}
