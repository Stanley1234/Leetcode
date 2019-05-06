class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        sum = 0
        for ch in s:
            sum = sum * 26 + (ord(ch) - ord('A') + 1)
        return sum