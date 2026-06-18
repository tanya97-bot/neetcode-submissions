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
        Collections.sort(intervals, (a,b) -> 
        {
            if(a.start == b.start) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });

        PriorityQueue<Integer> exits = new PriorityQueue<>();
        int rooms = 0;
        for(Interval i: intervals)
        {
            if(exits.isEmpty())
            {
                exits.offer(i.end);
                rooms++;
            }
            else if(i.start < exits.peek())
            {
                rooms++;
                exits.offer(i.end);
            }
            else
            {
                exits.offer(Math.max(exits.poll(), i.end));
            }
        }
        return rooms;
    }
}
