class Solution {
    public int maxSubArray(int[] nums) {
        int lsum = 0;
        int gsum = Integer.MIN_VALUE;
        for(int n: nums)
        {
            lsum += n;
            lsum = Math.max(lsum, n);
            gsum = Math.max(gsum, lsum);
        }
        return gsum;
    }
}
