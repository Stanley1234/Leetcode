class Solution {
    public String reverseString(String s) {
        char[] strArray = s.toCharArray();
        for (int i = 0;i < strArray.length / 2;i ++) {
            char temp = strArray[i];
            strArray[i] = strArray[strArray.length - i - 1];
            strArray[strArray.length - i - 1] = temp;
        }
        return String.valueOf(strArray);
    }
}