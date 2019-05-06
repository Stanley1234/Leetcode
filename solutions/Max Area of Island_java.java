class Solution {
    
    private class Coord {
        public int r;
        public int c;
        public Coord(int i, int j) {
            this.r = i;
            this.c = j;
        }
    }
    
    private static final int[] R_OFFSET = {-1, 0, 0, 1};
    private static final int[] C_OFFSET = {0, 1, -1, 0};
    private static final int NUM_OF_DIR = 4;
    
    private int search(int[][] grid, int i, int j) {
        int gridWidth = grid[0].length;
        int gridHeight = grid.length;
        
        int area = 1;
        grid[i][j] = 0;
        
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(i, j));
        while (!queue.isEmpty()) {
            Coord cur = queue.poll();
            for (int k = 0;k < NUM_OF_DIR;k ++) {
                int nextRow = cur.r + R_OFFSET[k];
                int nextCol = cur.c + C_OFFSET[k];
                
                if (nextRow < 0 || nextRow >= gridHeight || nextCol < 0 || nextCol >= gridWidth ||                     grid[nextRow][nextCol] == 0) {
                    continue;
                }
                queue.offer(new Coord(nextRow, nextCol));
                area ++;
                grid[nextRow][nextCol] = 0;
            }
        }
        return area;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int maxArea = 0;
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                maxArea = Math.max(maxArea, search(grid, i, j));
            }
        }
        return maxArea;
    }
}