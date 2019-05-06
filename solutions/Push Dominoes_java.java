class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int pushed = 0;
        boolean right = false;  // false means mid
        
        for (int i = 0;i < dominoes.length();i ++) {
            char ch = dominoes.charAt(i);
            if (right) {
                if (ch == '.') { 
                    sb.append("R");
                    pushed ++;
                } else if (ch == 'R') {
                    sb.append("R");
                    pushed = 1;
                } else {
                    sb.append("L");
                    pushed ++;
                    
                    int leftMove = pushed / 2 - 1;
                    for (int j = 1;j <= leftMove;j ++)
                        sb.setCharAt(i - j, 'L');  
                    if (pushed % 2 == 1) 
                        sb.setCharAt(i - leftMove - 1, '.');
                    
                    right = false;
                    pushed =  0;
                }
            } else {
                if (ch == '.') {
                    sb.append(".");
                } else if (ch == 'R') {
                    right = true;
                    pushed = 1;
                    sb.append("R");
                } else {
                    sb.append("L");
                    for (int j = i - 1;j >= 0 && sb.charAt(j) != 'L'; j --) {
                        sb.setCharAt(j, 'L');
                    }
                }
            }
        }
        return sb.toString();
    }
}