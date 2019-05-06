class Solution {
    
    
    public int[] preprocess(String needle) {
        int[] table = new int[needle.length()];
        int j = 0, i = 1;

        while (i < needle.length()) {
            if (needle.charAt(i) != needle.charAt(j))  {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    i ++;
                }

            } else {
                table[i] = j + 1;
                j ++;
                i ++;
            }
        }
        return table;
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        // good place to review KMP algorithm
        int[] prefixTable = preprocess(needle);

        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j ++;
                if (j == needle.length()) {
                    return i - j + 1;
                }
                i ++;
            } else {
                if (j != 0) {
                    j = prefixTable[j - 1];
                } else {
                    i ++;
                }
            }
        }
        return -1;
    }
}