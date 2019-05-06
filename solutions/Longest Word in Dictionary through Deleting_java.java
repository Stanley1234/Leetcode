class Solution {
    public String findLongestWord(String s, List<String> d) {
        int numOfWordsInDict = d.size();
        int[] curPos = new int[numOfWordsInDict];   // curPos points the next character to be checked
        
        Collections.sort(d);
        
        for (char ch : s.toCharArray()) {
            for (int i = 0;i < numOfWordsInDict;i ++) {
                if (curPos[i] < d.get(i).length() && ch == d.get(i).charAt(curPos[i])) {  
                    curPos[i] ++;
                }
            }
        }
        
        int ansIndex = -1; 
        for (int i = numOfWordsInDict - 1;i >= 0;i --) {
            if (curPos[i] == d.get(i).length()) {
                if (ansIndex == -1 || d.get(ansIndex).length() <= d.get(i).length()) {
                    ansIndex = i;
                } 
            }
        }
        
        return ansIndex == -1 ? "" : d.get(ansIndex);
    }
}