class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> used = new HashSet<Character>();
        int maxLen = 0;

        int i = 0, j = 0;
        while(j < s.length()) {
            if(!used.contains(s.charAt(j))) {
                used.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                j ++;
            } else {
                while(used.contains(s.charAt(j))) {
                    used.remove(s.charAt(i));
                    i ++;
                }
            }
        }

        return maxLen;
    }
}