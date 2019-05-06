class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        for (int i = 0;i < board.length;i ++) {
            for (int j = 0;j < board[0].length;j ++)    {
                int liveCells = getLiveCells(board, i, j);
                
                if (board[i][j] == 1 && liveCells < 2) {  // dies
                    
                } else if (board[i][j] == 1 && 2 <= liveCells && liveCells <= 3) {
                    board[i][j] |= 0b100;
                    
                } else if (board[i][j] == 1 && liveCells > 3) {
                    
                } else if (board[i][j] == 0 && liveCells == 3) {
                    board[i][j] |= 0b100;
                    
                }
            }
        }
        
        for (int i = 0;i < board.length;i ++) {
            for (int j = 0;j < board[0].length;j ++) {
                board[i][j] >>= 2;
            }
        }
        
    }
    
    private int getLiveCells(int[][] board, int i, int j) {
        int liveCells = 0;
        
        for (int x = i - 1;x <= i + 1;x ++) {
            if (x < 0 || x >= board.length) {
                continue;
            }
            
            for (int y = j - 1;y <= j + 1;y ++) {
                if (y < 0 || y >= board[0].length || (x == i && y == j)) {
                    continue;
                }
                
                liveCells += board[x][y] & 1;
            }
        }
        return liveCells;
    }
}