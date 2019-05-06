class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) { return 0; }
        
        int[] diff = new int[A.length - 1];
        for (int i = 1;i < A.length;i ++) {
            diff[i - 1] = A[i] - A[i - 1];
        }
        int contNum = 1;
        int curDiff = diff[0];
        int sum = 0;
        for (int i = 1;i < diff.length;i ++) {
            if (curDiff == diff[i]) {
                contNum ++;
            } else {
                if (contNum >= 2) {
                    sum += (contNum * (contNum - 1) / 2);
                }
                contNum = 1;
                curDiff = diff[i];
            }
        }
        if (contNum >= 2) {
            sum += (contNum * (contNum - 1) / 2);
        }
        
        return sum;
    }
}