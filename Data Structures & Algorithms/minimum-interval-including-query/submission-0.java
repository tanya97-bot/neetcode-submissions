class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int[][] ss = new int[queries.length][2];
        for(int i=0; i< queries.length; i++)
        {
            ss[i] = new int[]{queries[i], i};
        }
        Arrays.sort(ss, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> 
            {
                int res = Integer.compare(a[1]-a[0], b[1]-b[0]);
                if(res == 0) return Integer.compare(a[0], b[0]);
                return res;
            }
        );
        int idx = 0;
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        for(int[] sq : ss)
        {
            int q = sq[0];
            while(idx < intervals.length && intervals[idx][0] <= q)
            {
                minHeap.offer(intervals[idx]);
                idx++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < q)
            {
                minHeap.poll();
            }
            if(!minHeap.isEmpty())
            {
                res[sq[1]] = minHeap.peek()[1]-minHeap.peek()[0] +1;
            }
        }
        return res;
    }
}
