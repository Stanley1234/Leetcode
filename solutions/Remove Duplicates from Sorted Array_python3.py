class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        sorted(nums)
        
        new = 0
        cur = 0
        
        while cur + 1 < len(nums):
            if nums[cur] != nums[cur + 1]:
                nums[new] = nums[cur]
                new += 1
                cur += 1
                continue
            
            while cur + 1 < len(nums) and nums[cur] == nums[cur + 1]:
                cur += 1
            
        if cur == len(nums) - 1:
            nums[new] = nums[cur]
            new += 1
        
        return new