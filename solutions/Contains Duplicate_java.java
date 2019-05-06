class Solution {
    public boolean containsDuplicate(int[] nums) {
      HashSet<Integer> numberCount = new HashSet<>();
      for (int num : nums) {
         if (numberCount.contains(num)) {
            return true;
         }
         numberCount.add(num);
      }
      return false;
   }
}