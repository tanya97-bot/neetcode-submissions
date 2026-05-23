class Solution {
    String s1;
    String s2;
    String s3;
    int[][] mem;
    public boolean isInterleave(String s1, String s2, String s3) {
        mem = new int[s1.length()+1][s2.length()+1];
        for(int[] m: mem)
        {
            Arrays.fill(m, -1);
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return helper(0,0, 0);
    }

    private boolean helper(int i, int j, int k)
    {
        if(k == s3.length() && i == s1.length() && j == s2.length()) return true;

        if(k == s3.length()) return false;

        if(i >= s1.length() && j >= s2.length()) return false;

        if( mem[i][j] != -1)
        {
            if(mem[i][j] == 1) return false;
            return true;
        }

        boolean res = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k))
        {
            res = helper(i+1, j, k+1);
        }   
        if(!res && j < s2.length() && s2.charAt(j) == s3.charAt(k))
        {
            res = helper(i, j+1, k+1);
        }
        if(res)
        {
            mem[i][j] = 2;
        }
        else 
        {
            mem[i][j] = 1;
        }
        return res;
    }
}
