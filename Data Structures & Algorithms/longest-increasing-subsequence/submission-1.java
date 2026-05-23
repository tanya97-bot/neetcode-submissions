class Solution {
    Integer[][]memo;
    public int lengthOfLIS(int[] nums) {
        memo = new Integer[nums.length][nums.length+1];
        return maxList(-1, 0, nums);
    }

    private int maxList(int prev, int curr, int[]nums)
    {
        if(curr >= nums.length) return 0;
        if(memo[curr][prev+1] != null) return memo[curr][prev+1];
        int max = 0;
        if( prev == -1  || nums[curr] > nums[prev])
        {
            max = 1+maxList(curr, curr+1, nums);
        }
        max = Math.max(max, maxList(prev, curr+1, nums));
        memo[curr][prev+1] = max;
        return max;
    }
}
