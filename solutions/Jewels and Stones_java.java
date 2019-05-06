class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char ch : J.toCharArray()) {
            jewels.add(ch);
        }
        
        int cnt = 0;
        for (char stone : S.toCharArray()) {
            if (jewels.contains(stone)) {
                cnt ++;
            }
        }
        
        return cnt;
    }
}