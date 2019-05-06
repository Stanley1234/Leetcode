class Solution {
    public int maxProfit (int[] prices) {
      if (prices.length <= 1) {
          return 0;
      }
        
      int maxSell = prices[prices.length - 1];
      int maxProfit = Math.max(0, maxSell - prices[prices.length - 2]);

      int index = prices.length - 3;

      while (index >= 0) {
         maxSell = Math.max(maxSell, prices[index + 1]);
         maxProfit = Math.max(maxProfit, maxSell - prices[index]);
         index --;
      }
      return maxProfit;
   }
}