class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for(int[]t : triplets)
        {
           if(t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2])
           {
           if(!a && t[0] == target[0])  a = true;
           if(!b && t[1] == target[1]) b = true;
           if(!c && t[2] == target[2]) c = true;

           if(a && b && c) return true;
           }
        }
        return false;
    }
}
