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
        Collections.sort(intervals, (a, b) -> 
        {
            if(a.start == b.start)
            {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.start, b.start);
        });
        PriorityQueue<Integer> ongoingRooms = new PriorityQueue<>();
        int prev = 0;
        ongoingRooms.offer(intervals.get(0).end);
        int rooms = 1;

        for(int i=1; i< intervals.size(); i++)
        {
            if(!ongoingRooms.isEmpty() && ongoingRooms.peek() <= 
            intervals.get(i).start)
            {
                ongoingRooms.poll();
                ongoingRooms.offer(intervals.get(i).end);
            }else
            {
                rooms++;
                ongoingRooms.offer(intervals.get(i).end);
            }
        }
        return rooms;
    }
}
