class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int r = grid.length, c = grid[0].length;
        int perimeter = 0;
        
        for (int i = 0;i < r;i ++) {
            for (int j = 0;j < c;j ++) {
                if (grid[i][j] == 0) { continue; }
                perimeter += 4;
                if (i > 0 && grid[i - 1][j] == 1)  { perimeter --; }
                if (i < r - 1 && grid[i + 1][j] == 1) { perimeter --; }
                if (j > 0 && grid[i][j - 1] == 1) { perimeter --; }
                if (j < c - 1 && grid[i][j + 1] == 1) { perimeter --; }
            }
        }
        return perimeter;
    }
}