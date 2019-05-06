class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) { return true; }
        if (t.length() == 0 || s.length() > t.length()) { return false; }
    
        int k = 0;
        for (int i = 0;i < t.length();i ++) {
            if (t.charAt(i) != s.charAt(k)) {
                continue;
            }
            k ++;
            if (k == s.length()) {
                break;
            }
        }
        return k == s.length();
    }
}