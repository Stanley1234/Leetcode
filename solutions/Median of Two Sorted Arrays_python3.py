class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        total_len = len(nums1) + len(nums2)
        if total_len % 2 == 1:
            return self.kth(nums1, nums2, total_len // 2 + 1)
        else:
            return (self.kth(nums1, nums2, total_len // 2) + self.kth(nums1, nums2, total_len // 2 + 1)) / 2

    def kth(self, A, B, k):
        """
            Compute the kth number from the presumably merged array of A and B.
            Note that
                - k starts from 1
                - k <= len(A) + len(B)
        """
        if not A:
            return B[k - 1]
        if not B:
            return A[k - 1]
        if k == 1:
            return min(A[0], B[0])
        if len(A) == 1:
            if A[0] < B[k - 2]:
                return B[k - 2]
            elif len(B) == k - 1 or A[0] < B[k - 1]:
                return A[0]
            else:
                return B[k - 1]
        if len(B) == 1:
            if B[0] < A[k - 2]:
                return A[k - 2]
            elif len(A) == k - 1 or B[0] < A[k - 1]:
                return B[0]
            else:
                return A[k - 1]

        # get a pivot index
        ia = (len(A) - 1) // 2
        ib = (len(B) - 1) // 2

        # k-th number is in one of the four areas
        # A[0 ... ia], A[ia+1, ..., len(A) - 1]
        # B[0 ... ib], B[ib+1, ..., len(B) - 1]

        if k > ia + ib + 2:
            # kth number will not appear in either A[0...ia] or B[0...ib]
            if A[ia] >= B[ib]:
                return self.kth(A, B[ib + 1:], k - ib - 1)
            else:
                return self.kth(A[ia + 1:], B, k - ia - 1)
        else:
            # kth number will not appear in either A[ia+1, ..., len(A) - 1] or B[ib+1, ..., len(B) - 1]
            if A[ia] >= B[ib]:
                return self.kth(A[0: ia + 1], B, k)
            else:
                return self.kth(A, B[0: ib + 1], k)

