class Solution {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> d1 = new HashSet<>();
    HashSet<Integer> d2 = new HashSet<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
         cols = new HashSet<>();
         d1 = new HashSet<>();
         d2 = new HashSet<>(); 
         List<List<String>> res = new ArrayList<>();
         generateNQueens(0, res, new int[n]);
         return res;
    }
    private void generateNQueens(int row, List<List<String>> res, int[] queens)
    {
        if(row == n)
        {
            List<String> cl = new ArrayList<>();
            for(int q: queens)
            {
                char[] crow = new char[n];
                Arrays.fill(crow, '.');
                crow[q] = 'Q';
                cl.add(new String(crow));
            }
            res.add(cl);
            return;
        }
        for(int col = 0; col < n; col++)
        {
            if(!cols.contains(col) && !d1.contains(row-col) && !d2.contains(row+col))
            {
                cols.add(col);
                d1.add(row-col);
                d2.add(row+col);
                queens[row] = col;
                generateNQueens(row+1, res, queens);
                d1.remove(row-col);
                d2.remove(row+col);
                cols.remove(col);
            }
        }
    }
}
