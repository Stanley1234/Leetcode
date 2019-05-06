class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0:
            return 0
        buy = [0] * len(prices)
        sell = [0] * len(prices)
        
        buy[0] = -prices[0]
        for index, price in enumerate(prices[1:], start=1):
            buy[index] = max(buy[index - 1], sell[index - 1] - price)
            sell[index] = max(sell[index - 1], buy[index - 1] + price)
        return sell[len(prices) - 1]