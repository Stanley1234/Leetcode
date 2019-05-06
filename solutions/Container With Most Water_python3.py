class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1

        max_capacity = 0
        while left <= right:
            cur_capacity = min(height[left], height[right]) * (right - left)
            max_capacity = max(max_capacity, cur_capacity)
            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1
        return max_capacity