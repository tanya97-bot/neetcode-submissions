class Solution {
     int[][] visited ;
    public int longestIncreasingPath(int[][] matrix) {
        visited = new int[matrix.length][matrix[0].length];
        for(int[] v:  visited) Arrays.fill(v, -1);
        int max = 1;
        for(int i=0; i < matrix.length; i++)
        {
            for(int j=0; j< matrix[0].length; j++)
            {
                if(visited[i][j] == -1)
                {
                    max = Math.max(max, visit(i, j, matrix));
                }
            }
        }
        return max;
    }
    int[][]dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private int visit(int i, int j, int[][]m)
    {
        if(m[i][j] == -1) return 0;
        if(visited[i][j] != -1) return visited[i][j];
        int max = 1;
        for(int[] d: dir)
        {
        int x = d[0]+i;
        int y = d[1]+j;
        if(0 <= x && 0 <= y && x < m.length && y < m[0].length &&
        m[x][y] > m[i][j] && m[x][y] != -1)
        {
            max = Math.max(max, 1+visit(x,y,m));
        }
        }
        visited[i][j] = max;
        return max;
    }
}
