class Solution {
    int sum;
    public boolean canPartition(int[] nums) {
        sum = Arrays.stream(nums).sum(); 
        return canPart(nums, 0, 0);
    }

    private boolean canPart(int[]nums, int i, int csum)
    {
        if(i >= nums.length) return false;
        if(csum == sum-csum) return true;
        return canPart(nums, i+1, csum+nums[i]) || canPart(nums, i+1, csum);
    }
}
