# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(-1)
        
        c1 = l1
        c2 = l2
        cur = dummy
        while c1 and c2:
            if c1.val <= c2.val:
                cur.next = c1
                c1 = c1.next
            else:
                cur.next = c2
                c2 = c2.next
            cur = cur.next
        
        if c1:
            cur.next = c1
        if c2:
            cur.next = c2
        return dummy.next
            