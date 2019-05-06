class Solution {
    public int findLHS(int[] nums) {
      Map<Integer, Integer> numberCount = new HashMap<>();
      for (int n : nums) {
         numberCount.put(n, numberCount.getOrDefault(n, 0) + 1);
      }

      int maxLength = 0;
      for (int cur : numberCount.keySet()) {
         if (numberCount.containsKey(cur - 1)) {
            maxLength = Math.max(maxLength, numberCount.get(cur - 1) + numberCount.get(cur));
         }
         if (numberCount.containsKey(cur + 1)) {
            maxLength = Math.max(maxLength, numberCount.get(cur) + numberCount.get(cur + 1));
         }
      }
      return maxLength;
   }
}