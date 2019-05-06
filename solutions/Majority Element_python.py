class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        x = nums[0]
        cnt = 1
        for _, num in enumerate(nums[1:]):
            if cnt == 0:
                x = num
                cnt = 1
            elif num == x:
                cnt += 1
            else:
                cnt -= 1
        return x
        