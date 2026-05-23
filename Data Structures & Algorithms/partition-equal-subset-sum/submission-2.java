class Solution {
    Boolean[][]memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum(); 
        if(sum % 2 != 0) return false;
        memo = new Boolean[nums.length][sum/2 + 1];
        return canPart(nums, 0, sum/2);
    }

    private boolean canPart(int[]nums, int i, int csum)
    {
        if(csum == 0) return true;
        if(i >= nums.length) return false;
        if(0 > csum ) return false;
        if(memo[i][csum] == null)
        {
        memo[i][csum]= canPart(nums, i+1, csum-nums[i]) || canPart(nums, i+1, csum);
        }
        return memo[i][csum];
    }
}
