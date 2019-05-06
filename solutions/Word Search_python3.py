class Solution:
    DIRECTIONS = [
        [-1, 0],
        [1, 0],
        [0, 1],
        [0, -1]
    ]

    def search(self, board, word, s, t, word_index, visited):
        if word_index == len(word):
            return True

        [r, c] = [len(board), len(board[0])]

        for direction in Solution.DIRECTIONS:
            [i, j] = direction
            [ns, nt] = [s + i, t + j]
            if ns < 0 or nt < 0 or ns >= r or nt >= c:
                continue
            if visited[ns][nt] or board[ns][nt] != word[word_index]:
                continue
            visited[ns][nt] = True
            if self.search(board, word, ns, nt, word_index + 1, visited):
                return True
            visited[ns][nt] = False
        return False

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if len(board) == 0 or len(board[0]) == 0:
            return False
        if len(word) == 0:
            return True

        [i, j] = [0, 0]
        [r, c] = [len(board), len(board[0])]

        while i < r and j < c:
            if word[0] == board[i][j]:
                visited = [[False for _ in range(c)] for _ in range(r)]
                visited[i][j] = True
                if self.search(board, word, i, j, 1, visited):
                    return True

            j += 1
            if j == c:
                i += 1
                j = 0
        return False
