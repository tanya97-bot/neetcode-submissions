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
         generateNQueens(0, new ArrayList<>(), res);
         return res;
    }
    String dot = ".";
    private void generateNQueens(int row, List<String> cl, List<List<String>> res)
    {
        if(row == n)
        {
            res.add(new ArrayList<>(cl));
            return;
        }
        for(int col = 0; col < n; col++)
        {
            if(!cols.contains(col) && !d1.contains(row-col) && !d2.contains(row+col))
            {
                cols.add(col);
                d1.add(row-col);
                d2.add(row+col);
                String resStr = dot.repeat(col)+'Q'+dot.repeat(Math.max(0, n-col-1));
                cl.add(resStr);
                generateNQueens(row+1, cl, res);
                cl.remove(cl.size()-1);
                d1.remove(row-col);
                d2.remove(row+col);
                cols.remove(col);
            }
        }
    }
}
