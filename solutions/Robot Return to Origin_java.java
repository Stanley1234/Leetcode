class Solution {
    public boolean judgeCircle(String moves) {
        int r = 0, c = 0;
        for (char operation : moves.toCharArray()) {
            switch (operation) {
            case 'U': r --; break;
            case 'D': r ++; break;
            case 'L': c --; break;
            case 'R': c ++; break;
            }
        }
        return r == 0 && c == 0;
    }
    
}