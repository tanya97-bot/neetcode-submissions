class Solution {
    public List<Integer> partitionLabels(String s) {
        List<int[]> intervals = new ArrayList<>();
        HashMap<Character, int[]> rangeMap = new HashMap<>();
        for(int i=0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            int[] arr;
            if(!rangeMap.containsKey(c))
            {
                arr = new int[2];
                arr[0] = i;
                arr[1] = i;
                rangeMap.put(c, arr);
            }
            else
            {
                arr = rangeMap.get(c);
                arr[1] = i;
            }
        }
        for(int[] r: rangeMap.values())
        {
            intervals.add(r);
        }
        Collections.sort(intervals, (a,b)-> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int prev = intervals.get(0)[1];
        int start = intervals.get(0)[0];
        List<Integer> result = new ArrayList<>();
        for(int i=1; i< intervals.size(); i++)
        {
            if(intervals.get(i)[0] < prev)
            {
                prev = Math.max(prev, intervals.get(i)[1]);
            }
            else
            {
                result.add(prev-start+1);
                prev = intervals.get(i)[1];
                start = intervals.get(i)[0];
            }
            if(i == intervals.size() -1) result.add(prev-start+1);

        }
        return result;
    }
}


// 0, 3 1, 4 5,8 