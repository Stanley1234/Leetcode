class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0 && B.length() == 0)  {
            return true;
        }
        
        int curSearchedIndex = B.indexOf(A.charAt(0));
        boolean equal = false;
        
        while (curSearchedIndex != -1) {
            int pA = 0, pB = curSearchedIndex;
            equal = true;
            while (pA < A.length()) {
                if (A.charAt(pA) != B.charAt(pB)) {
                    equal = false;
                    break;
                }
                
                pA ++;
                pB = (pB + 1) % B.length();
            }
            
            if (equal) {
                break;
            }
            curSearchedIndex = B.indexOf(A.charAt(0), curSearchedIndex + 1);
        }
        
        return equal;
    }
}