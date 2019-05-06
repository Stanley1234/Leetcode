class Solution(object):
    def addTwoNumbers(self, l1, l2):
        
        cur = head = ListNode(0)
        extra = 0
        while l1 or l2 or extra > 0:
            sum = extra
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
            cur.next = ListNode(sum % 10)
            extra = int(sum / 10)
            cur = cur.next
        return head.next