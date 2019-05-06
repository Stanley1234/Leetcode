
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # dp[i][j] is True if p[0...j] matches s[0...i]
        # 1. When p[j] == '.'
        #       dp[i][j] = dp[i - 1][j - 1]
        # 2. When p[j] == '*'
        #       dp[i][j] = True   If s[i] == p[j - 1]
        # 3. Else
        #       dp[i][j] = dp[i - 1][j - 1]   If s[i] == p[j]
        #       dp[i][j] = False              If s[i] != p[j]
        s = '?' + s
        p = '?' + p

        dp = [[False for _ in range(len(p))] for _ in range(len(s) + 1)]
        dp[0][0] = True
        for j in range(1, len(p), 2):
            if j + 1 < len(p) and p[j + 1] == '*':
                dp[0][j + 1] = True
                # print("dp[%s][%s]=%s" % (0, j+1, dp[0][j+1]))
            else:
                break

        for i in range(1, len(s)):
            for j in range(1, len(p)):
                if p[j] == '.':
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j] == '*':
                    # first choice, not matched with the current regx (i.e. .*, c*)
                    dp[i][j] = dp[i][j - 2]
                    if s[i] == p[j - 1] or p[j - 1] == '.':
                        # try to match
                        dp[i][j] |= dp[i - 1][j] | dp[i - 1][j - 2]
                else:
                    if s[i] == p[j]:
                        dp[i][j] = dp[i - 1][j - 1]
                # print("dp[%s][%s]=%s"%(i, j, dp[i][j]))
        return dp[len(s) - 1][len(p) - 1]
