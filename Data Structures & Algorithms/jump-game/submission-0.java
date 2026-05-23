class Solution {
    public boolean canJump(int[] nums) {
        return jumpHelper(0, nums);
    }

    private boolean jumpHelper(int idx, int[]nums)
    {
        if(idx == nums.length-1) return true;
        if(idx > nums.length) return false;

        for(int j=1; j<=nums[idx]; j++)
        {
            if(jumpHelper(idx+j, nums)) return true;
        }
        return false;
    }
}
