class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (true) {
            while (i < s.length() && !Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) { i                 ++; }
            while (j >= 0 && !Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) { j --; }
            
            if (i >= j) { break; }
            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) { return false; }
            
            i ++;
            j --;
        }
        return true;
    }
}