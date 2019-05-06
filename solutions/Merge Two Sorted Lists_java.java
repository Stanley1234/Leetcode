/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // mix l2 into l1
        ListNode head = new ListNode(-1);
        head.next = l1;
        
        ListNode prevP1 = head;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                prevP1 = p1;
                p1 = p1.next;
            } else {
                ListNode nextP2 = p2.next;
                
                prevP1.next = p2;
                p2.next = p1;
                
                prevP1 = p2;
                p2 = nextP2;
            }   
        }
        if (p2 != null) {
            prevP1.next = p2;
        }
        return head.next;
    }
}