class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        singleton = nums[0]
        for _, n in enumerate(nums[1:]):
            singleton ^= n
        return singleton
        