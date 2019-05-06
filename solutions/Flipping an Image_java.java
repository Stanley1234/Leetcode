class Solution {
    private void flipImage(int[][] image) {
        int r = image.length, c = image[0].length;
        for (int i = 0;i < r;i ++) {
            for (int j = 0;j < c / 2;j ++) {
                int tmp = image[i][j];
                image[i][j] = image[i][c - j - 1];
                image[i][c - j - 1] = tmp;
            }
        }
    }
    
    private void invertImage(int[][] image) {
        int c = image[0].length;
        for (int[] row : image) {
            for (int j = 0;j < c;j ++) {
                row[j] = (row[j] == 0 ? 1 : 0);
            }
        }
    }
    
    public int[][] flipAndInvertImage(int[][] image) {
        flipImage(image);
        invertImage(image);
        return image;
    }
}