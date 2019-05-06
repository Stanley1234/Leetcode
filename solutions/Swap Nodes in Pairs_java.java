/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode wrap = new ListNode(0);
        wrap.next = head;

        ListNode prev = wrap;
        ListNode cur = head;

        while(cur != null && cur.next != null) {
            ListNode n2 = cur.next.next;
            ListNode n1 = cur;
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            cur = n2;
            prev = n1;
        }

        return wrap.next;
    }
}