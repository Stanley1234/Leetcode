class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        visited = set()
        head = 0
        curLen = maxLen = 0
        for tail, ch in enumerate(s):
            if ch in visited:
                while True:
                    visited.remove(s[head])
                    curLen -= 1
                    head += 1
                    if s[head - 1] == ch or head == tail:
                        break
            curLen += 1
            maxLen = max(curLen, maxLen)
            visited.add(ch)
        maxLen = max(curLen, maxLen)
            
                
        return maxLen
            
        