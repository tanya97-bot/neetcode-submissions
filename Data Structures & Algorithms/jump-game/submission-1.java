class Solution {
    Boolean[] mem;
    public boolean canJump(int[] nums) {
        mem = new Boolean[nums.length];
        return jumpHelper(0, nums);
    }

    private boolean jumpHelper(int idx, int[]nums)
    {
        if(idx == nums.length-1) return true;
        if(idx > nums.length) return false;
        if(mem[idx] != null) return mem[idx]; 
        mem[idx] = false;
        for(int j=1; j<=nums[idx]; j++)
        {
            if(jumpHelper(idx+j, nums))
            {
                mem[idx] = true;
                break;
            }
        }
        return mem[idx];
    }
}
