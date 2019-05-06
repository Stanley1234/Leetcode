class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0) return ans;
        
        int r = 0, c = 0;
        int nb = 0, sb = matrix.length - 1;
        int wb = 0, eb = matrix[0].length - 1;

        while (nb < sb && wb < eb) {
            while (c <= eb) { ans.add(matrix[r][c]); c ++; }
            c --; r ++; eb --;
            while (r <= sb) { ans.add(matrix[r][c]); r ++; }
            r --; c --; sb --;
            while (c >= wb) { ans.add(matrix[r][c]); c --; }
            c ++; r --; wb ++; nb ++;
            while (r >= nb) { ans.add(matrix[r][c]); r --; }
            r ++; c ++;
        }

        if(nb == sb) { while (c <= eb) { ans.add(matrix[r][c]); c ++; } }
        else if(wb == eb) { while (r <= sb) { ans.add(matrix[r][c]); r ++; } };

        return ans;
    }
}