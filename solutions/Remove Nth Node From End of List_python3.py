class Solution:
    def _get_length_of_list(self, head: ListNode) -> int:
        length = 0
        while head:
            head = head.next
            length += 1
        return length

    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        length = self._get_length_of_list(head)
        n = length - n

        dummy = ListNode(-1)
        dummy.next = head

        prev = dummy
        cur = head
        while n >= 1:
            prev = prev.next
            cur = cur.next
            n -= 1

        prev.next = cur.next
        return dummy.next
