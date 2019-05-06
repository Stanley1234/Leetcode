class Solution {
    private int count(int[] nums, int key) {
      int cnt = 0;
      for (int n : nums) {
         if (n == key) {
            cnt ++;
         }
      }
      return cnt;
   }

   public List<Integer> majorityElement(int[] nums) {
      int c1Num = 0, c2Num = 0;
      int c1Cnt = 0, c2Cnt = 0;
      for (int n : nums) {
         if (n == c1Num) {
            c1Cnt ++;
         } else if (n == c2Num) {
            c2Cnt ++;
         } else if (c1Cnt == 0) {
            c1Num = n;
            c1Cnt = 1;
         } else if (c2Cnt == 0) {
            c2Num = n;
            c2Cnt = 1;
         } else {
            c1Cnt --;
            c2Cnt --;
         }
      }

      List<Integer> ans = new ArrayList<>();
      if (c1Cnt != 0 && count(nums, c1Num) > nums.length / 3) {
         ans.add(c1Num);
      }
      if (c2Cnt != 0 && count(nums, c2Num) > nums.length / 3) {
         ans.add(c2Num);
      }

      return ans;
   }
}