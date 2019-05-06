class Solution {
    public int lengthOfLastWord(String s) {
        /*String[] words = s.split("\s+");
        int i;
        for (i = words.length - 1;i >= 0;i --) {
            if (!words[i].isEmpty()) {
                break;  
            }
        }
        return words[i].length();*/
        String[] words = s.split(" +");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }
}