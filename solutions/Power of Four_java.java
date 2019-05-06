class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && 1073741824 % num == 0 && (Math.sqrt(num) * Math.sqrt(num) == (double)num);
    }
}