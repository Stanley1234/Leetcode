class Solution {
    public int numRabbits(int[] answers) {
      HashMap<Integer, Integer> counter = new HashMap<>();
      for (int answer : answers) {
         counter.put(answer, counter.getOrDefault(answer, 0) + 1);
      }

      int totalNum = 0;
      for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
         int answer = entry.getKey();
         int cnt = entry.getValue();

         if (cnt % (answer + 1) == 0) {
            totalNum += cnt;
         } else {
            totalNum += (cnt / (answer + 1) + 1) * (answer + 1);
         }
      }
      return totalNum;
   }
}