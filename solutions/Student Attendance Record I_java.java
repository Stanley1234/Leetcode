class Solution {
    public boolean checkRecord(String s) {
        int absentCnt = 0;
        int lateContCnt = 0;
        for (char record : s.toCharArray()) {
            if (record == 'A') {
                absentCnt ++;
                lateContCnt = 0;
            } else if (record == 'L') {
                lateContCnt ++;
            } else {
                lateContCnt = 0;
            }
            if (absentCnt > 1 || lateContCnt > 2) {
                return false;
            }
        }
        return true;
    }
}