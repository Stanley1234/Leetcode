class Solution(object):
    def canCross(self, stones):
        """
        Method 1: MLE
            dist = stones[i] - stones[j]
            dp[i][dist] = dp[j][dist - 1] | dp[j][dist] | dp[j][dist + 1]

        Method 2: TLE
            dp[i][j] = True if for some 1 <= l < j
                dp[j][l] is True and
                |(stones[i] - stones[j]) - (stones[j] - stones[l])| <= 1
        """
        if stones[1] != 1:
            return False

        N = len(stones)

        dist = [set() for _ in range(N)]
        dist[1].add(1)

        for i in range(2, N):
            for j in reversed(range(1, i)):
                dist_ij = stones[i] - stones[j]
                possible_ls = dist[j]

                if dist_ij in possible_ls or (dist_ij + 1) in possible_ls or (dist_ij - 1) in possible_ls:
                    dist[i].add(dist_ij)

        return len(dist[N - 1]) > 0
