class Solution:
    def longestPalindrome(self, s: str) -> str:
        N = len(s)
        palin = [[False for _ in range(N)] for _ in range(N)]

        for i in range(N):   # 0 <= i <= N - 1
            palin[i][i] = True

        for i in range(N - 1):  # 0 <= i <= N - 2
            if s[i] == s[i + 1]:
                palin[i][i + 1] = True

        for k in range(3, N + 1):   # 3 <= i <= N
            for i in range(0, N - k + 1):   # 0 <= i <= N - k
                j = i + k - 1
                if s[i] == s[j] and palin[i + 1][j - 1]:
                    palin[i][j] = True

        for k in reversed(range(1, N + 1)):  # 1 <= k <= N
            for i in range(0, N - k + 1):    # 0 <= i <= N - k
                j = i + k - 1
                if palin[i][j]:
                    return s[i: j + 1]
        return ""

