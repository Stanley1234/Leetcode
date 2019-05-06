class Solution {
    private static final Map<Integer, Integer> rotation = new HashMap<>();
   {
      rotation.put(0, 0);
      rotation.put(1, 1);
      rotation.put(8, 8);

      rotation.put(2, 5);
      rotation.put(5, 2);

      rotation.put(6, 9);
      rotation.put(9, 6);
   }

   private int getRotation(int origin) {
      if (origin == 0) {
         return 0;
      }
      int higherDigits = getRotation(origin / 10);
      if (higherDigits == -1 || !rotation.containsKey(origin % 10)) {
         return -1;
      }
      return higherDigits * 10 + rotation.get(origin % 10);
   }

   public int rotatedDigits(int N) {
      // X is a good number if after rotating each digit individually by 180 degrees,
      // we get a valid number that is different from X.

      int goodNumberCnt = 0;

      for (int i = 1;i <= N;i ++) {
         int origin = i;
         int rotated = getRotation(origin);

         if (rotated > 0 && rotated != origin) {
            //System.out.println(rotated);
            goodNumberCnt ++;
         }
      }

      return goodNumberCnt;
   }
}