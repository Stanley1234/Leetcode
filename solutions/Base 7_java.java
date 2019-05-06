class Solution {
    public String convertToBase7(int num) {
        StringBuilder ans = new StringBuilder();
        boolean minusSign = false;
        if (num < 0) {
            minusSign = true;
            num = -num;
        }
        while (num > 0) {
            ans.append(num % 7);
            num /= 7;
        }
        if (ans.length() == 0) {  // when num is 0
            ans.append(0);
        }
        if (minusSign) {
            ans.append("-");   
        }
        return ans.reverse().toString();
    }
}