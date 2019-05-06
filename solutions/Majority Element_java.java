class Solution {
    public int majorityElement(int[] nums) {
      int cnt = 0;
      int elem = nums[0];

      for (int n : nums) {
         if (n == elem) {
            cnt ++;
         } else {
            cnt --;
            if (cnt == 0) {
               elem = n;
               cnt = 1;
            }
         }
      }

      return elem;
   }
}