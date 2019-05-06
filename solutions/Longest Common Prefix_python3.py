class Solution:

    def _get_common_prefix(self, s1, s2):
        prefix_cnt = 0
        while prefix_cnt < len(s1) and prefix_cnt < len(s2):
            if s1[prefix_cnt] != s2[prefix_cnt]:
                break
            prefix_cnt += 1
        return s1[0: prefix_cnt]

    def longestCommonPrefix(self, strs: List[str]) -> str:
        common_prefix = ""
        if len(strs) == 0:
            return common_prefix

        sorted(strs)
        common_prefix = strs[0]
        for i in range(1, len(strs)):
            common_prefix = self._get_common_prefix(common_prefix, strs[i])
        return common_prefix