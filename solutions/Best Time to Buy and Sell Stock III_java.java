class Solution {
    public int maxProfit(int[] prices) {
      if (prices.length <= 1) {
         return 0;
      }
      
      int[][] sell = new int [prices.length][3];
      int[][] buy = new int [prices.length][3];

      buy[0][0] = -prices[0];
      for (int i = 1;i < prices.length;i ++) {
         buy[i][0] = Math.max(buy[i - 1][0], -prices[i]);
         //System.out.println(String.format("buy[%d][%d]: %d", i, 0, buy[i][0]));
      }

      for (int k = 1;k <= 2;k ++) {
         for (int j = k * 2 - 1;j < prices.length;j ++) {
            sell[j][k] = Math.max(sell[j - 1][k], buy[j - 1][k - 1] + prices[j]);
            //System.out.println(buy[j - 1][k - 1] + "," + prices[j]);
            //System.out.println(String.format("sell[%d][%d]: %d", j, k, sell[j][k]));
         }

         if (k * 2 >= prices.length) {
            continue;
         }
         buy[k * 2][k] = sell[k * 2 - 1][k] - prices[k * 2];
         for (int j = k * 2 + 1;j < prices.length;j ++) {
            buy[j][k] = Math.max(buy[j - 1][k], sell[j - 1][k] - prices[j]);
            //System.out.println(String.format("buy[%d][%d]: %d", j, k, buy[j][k]));
         }
      }

      int maxProfit = 0;
      for (int k = 0;k <= 2;k ++) {
         maxProfit = Math.max(maxProfit, sell[prices.length - 1][k]);
      }
      return maxProfit;
   }
}