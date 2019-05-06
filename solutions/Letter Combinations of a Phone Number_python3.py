class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        digits_to_strs = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        result_lst = []

        for digit in digits:
            index = ord(digit) - ord('2')

            if not result_lst:
                result_lst.extend([ch for ch in digits_to_strs[index]])
                continue

            new_result_lst = []
            for result in result_lst:
                for ch in digits_to_strs[index]:
                    new_result_lst.append(result + ch)
            result_lst = new_result_lst

        return result_lst