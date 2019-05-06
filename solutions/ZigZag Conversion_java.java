class Solution {
    public String convert(String s, int numRows) {
        List<StringBuffer> rect = new ArrayList<>();
        boolean down = true;
        int r = 0;

        for(int i = 0;i < numRows;i ++)
            rect.add(new StringBuffer());

        for(int i = 0;i < s.length();i ++) {
            if(r == 0) down = true;
            else if(r == numRows - 1)  down = false;
            rect.get(r).append(s.charAt(i));
            if(down) r = Math.min(numRows - 1, r + 1);
            else r = Math.max(r - 1, 0);
        }

        return "".join("", rect);
    }
}