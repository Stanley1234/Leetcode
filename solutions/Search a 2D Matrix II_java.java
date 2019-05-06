class Solution {
    private boolean search(int[][] matrix, int target, int lrow, int lcol, int rrow, int rcol) {
        if(lrow > rrow || lcol > rcol) return false;

        int midRow = (lrow + rrow) / 2;
        int midCol = (lcol + rcol) / 2;
        if(matrix[midRow][midCol] == target)
            return true;
        if(target < matrix[midRow][midCol])
            return search(matrix, target, lrow, lcol, midRow, midCol - 1) ||
                    search(matrix, target, lrow, midCol, midRow -1 , rcol) ||
                    search(matrix, target, midRow + 1, lcol, rrow, midCol - 1);
        return search(matrix, target, lrow, midCol + 1, midRow, rcol) ||
                search(matrix, target, midRow + 1, midCol + 1, rrow, rcol) ||
                search(matrix, target, midRow + 1, lcol, rrow, midCol);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return search(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
}