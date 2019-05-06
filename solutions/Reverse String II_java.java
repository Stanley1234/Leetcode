class Solution {
    public String reverseStr(String s, int k) {
        int curIndex = 0;
        StringBuilder sb = new StringBuilder();
        while (curIndex < s.length()) {
            // reverse first k characters
            for (int start = Math.min(s.length() - 1, curIndex + k - 1); start >= curIndex; start --) {
                sb.append(s.charAt(start));
            }
            // keep the rest of current segment the same
            for (int start = curIndex + k; start < Math.min(curIndex + 2 * k, s.length()); start ++) {
                sb.append(s.charAt(start));
            }
            curIndex += 2 * k;
        }
        return sb.toString();
    }
}