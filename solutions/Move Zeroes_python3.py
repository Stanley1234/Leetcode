class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        first_zero = 0
        while first_zero < len(nums) and nums[first_zero] != 0:
            first_zero += 1
        cur = first_zero + 1
        while cur < len(nums):
            if nums[cur] == 0:
                cur += 1
                continue
            nums[first_zero], nums[cur] = nums[cur], nums[first_zero]
            first_zero += 1
            cur += 1