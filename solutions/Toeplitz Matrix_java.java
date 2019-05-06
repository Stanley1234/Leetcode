class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
      int r = matrix.length, c = matrix[0].length;
      int sr = r - 1, sc = 0;

      while (sr >= 0) {
         int cr = sr, cc = 0;
         int elem = matrix[cr][cc];
         while (cr < r && cc < c) {
            if (elem != matrix[cr][cc]) {
               return false;
            }
            cr ++;
            cc ++;
         }
         sr --;
      }

      sr ++;
      sc = 1;

      while (sc < c) {
         int cr = 0, cc = sc;
         int elem = matrix[cr][cc];
         while (cr < r && cc < c) {
            if (elem != matrix[cr][cc]) {
               return false;
            }
            cr ++;
            cc ++;
         }
         sc ++;
      }
      return true;
   }
}