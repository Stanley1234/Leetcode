class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        
        row_len = len(matrix)
        col_len = 0
        if(row_len > 0):
            col_len = len(matrix[0])
        
        col_to_be_modified = set()
        row_to_be_modified = set()
        
        for i in range(row_len):
            for j in range(col_len):
                if matrix[i][j] == 0:
                    col_to_be_modified.add(j)
                    row_to_be_modified.add(i)
                    
        for row_id in row_to_be_modified:
            for j in range(col_len):
                matrix[row_id][j] = 0
        
        for col_id in col_to_be_modified:
            for j in range(row_len):
                matrix[j][col_id] = 0
        
        
        
        