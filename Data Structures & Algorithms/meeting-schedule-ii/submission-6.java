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
        Collections.sort(intervals, (a,b) ->{
            if(a.start == b.start) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });
        PriorityQueue<Integer> exits = new PriorityQueue<>();
        int room = 0;
        for(Interval i : intervals)
        {
            int exit = -1;
            if(exits.isEmpty() || i.start < exits.peek())
            {
                room++;
            }
            else 
            {
                exit = exits.poll();
            }
            exits.offer(Math.max(exit,i.end));
        }
        return room;
    }
}
