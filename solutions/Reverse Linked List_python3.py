# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head

        helper = ListNode(-1)
        helper.next = head

        cur = head.next
        head.next = None
        while cur is not None:
            nextnode = cur.next
            cur.next = helper.next
            helper.next = cur
            cur = nextnode
        return helper.next
        