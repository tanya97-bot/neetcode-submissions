class Solution {
    public int missingNumber(int[] nums) {
        int n  = nums.length;
        int sum = (n*(n+1))/2;

        int sumnums = Arrays.stream(nums).sum();
        return sum-sumnums;
    }
}
