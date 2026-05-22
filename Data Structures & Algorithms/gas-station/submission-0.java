class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tg = Arrays.stream(gas).sum();
        int tc = Arrays.stream(cost).sum();
        if(tc > tg) return -1;
        int cg = 0;
        int start = 0;
        for(int i=0; i < gas.length; i++)
        {
            if(0 > cg)
            {
                cg = gas[i] - cost[i];
                start = i;
            }else
            {
                cg += gas[i]-cost[i];
            }
        }
        return start;
    }
}
