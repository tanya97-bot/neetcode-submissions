class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i< grid.length; i++)
        {
            for(int j=0; j< grid[0].length; j++)
            {
                if(grid[i][j] == 0)
                {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int distance = 0;
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            distance++;
            while(size-- > 0)
            {
                int[] curr = q.poll();
                for(int[]d: dir)
                {
                    int x = curr[0]+d[0];
                    int y = curr[1]+d[1];
                    if(x >= 0 && y >= 0 & x < grid.length && y < grid[0].length && grid[x][y] != -1 && !visited[x][y])
                    {
                        visited[x][y] = true;
                        grid[x][y] = distance;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
