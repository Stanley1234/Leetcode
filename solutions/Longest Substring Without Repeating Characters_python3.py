class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        counter = set()

        i = 0
        j = 0
        longest = 0
        cur = 0

        while j < len(s):
            if s[j] not in counter:
                counter.add(s[j])
                cur += 1
                longest = max(longest, cur)
                j += 1
            else:
                while s[j] in counter:
                    counter.remove(s[i])
                    i += 1
                    cur -= 1

        return longest
