class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        
        size = len(matrix[0])
        
        copy = [[0 for x in xrange(size)] for x in xrange(size)]
        for r, row in enumerate(matrix):
            for c, col in enumerate(row):
                copy[r][c] = matrix[size - c - 1][r]
        
        for r in xrange(size):
            for c in xrange(size):
                matrix[r][c] = copy[r][c]