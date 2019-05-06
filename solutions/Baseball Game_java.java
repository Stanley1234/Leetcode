class Solution {
    public int calPoints (String[] ops) {
      Stack<Integer> validRoundScore = new Stack<>();

      for (String op : ops) {
         if (op.equals("+")) {
            int prev1 = validRoundScore.pop();
            int prev2 = validRoundScore.pop();

            validRoundScore.push(prev2);
            validRoundScore.push(prev1);
            validRoundScore.push(prev1 + prev2);
         } else if (op.equals("C")) {
            validRoundScore.pop();
         } else if (op.equals("D")) {
            validRoundScore.push(validRoundScore.peek() * 2);
         } else {
            validRoundScore.push(Integer.parseInt(op));
         }
      }

      int totalPoints = 0;
      while (!validRoundScore.isEmpty()) {
         totalPoints += validRoundScore.pop();
      }
      return totalPoints;
   }
}