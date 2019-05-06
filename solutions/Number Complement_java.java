class Solution {
    public int findComplement(int num) {
      int highestValidBitPos = 31;
      while ((num & (1 << highestValidBitPos)) == 0) {
         highestValidBitPos--;
      }

      int complementNum = num;
      for (int i = 0;i <= highestValidBitPos;i ++) {
         if ((complementNum & (1 << i)) != 0) {
            complementNum -= (1 << i);
         } else {
            complementNum |= (1 << i);
         }
      }
      
      return complementNum;
   }
}