class Solution {
    public int longestMountain(int[] A) {
        if (A.length == 0) return 0;
        
        int[] up = new int[A.length];
        int[] down = new int[A.length];
        
        up[0] = 1;
        for (int i = 1;i < A.length;i ++) {
            if (A[i] > A[i - 1]) {
                up[i] = up[i - 1] + 1;
            } else {
                up[i] = 1;
            }
        }
        
        down[A.length - 1] = 1;
        for (int i = A.length - 2;i >= 0;i --) {
            if (A[i] > A[i + 1]) {
                down[i] = down[i + 1] + 1;
            } else {
                down[i] = 1;
            }
        }
        
        
        int maxLen = 0;
        for (int i = 0;i < A.length;i ++) {
            if (down[i] > 1 && up[i] > 1)
                maxLen = Math.max(maxLen, up[i] + down[i] - 1);
        }
        if (maxLen < 3) maxLen = 0;
        return maxLen;
    }
}