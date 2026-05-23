class Solution {
    public int swimInWater(int[][] grid) {
      PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> 
       Integer.compare(a[2], b[2])
      ); 
      minHeap.offer(new int[]{0,0, grid[0][0]}); 
      int max = Integer.MIN_VALUE;
      int[][] distance = new int[grid.length][grid[0].length];
      for(int[] d: distance)
      {
        Arrays.fill(d, Integer.MAX_VALUE);
      }
      distance[0][0] = grid[0][0];
      int[][]dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
      while(!minHeap.isEmpty())
      {
        int[] curr = minHeap.poll();
        if(distance[curr[0]][curr[1]] < curr[2]) continue;
        for(int[]d: dir)
        {
            int x = d[0]+curr[0];
            int y = d[1]+curr[1];
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) 
            {
            int z = Math.max(curr[2], grid[x][y]);
            if(distance[x][y] > z)
            {
            distance[x][y] = z;
            minHeap.offer(new int[]{x, y, z});
            }
            }
        }
      }
      return distance[grid.length-1][grid[0].length-1];
    }
}
