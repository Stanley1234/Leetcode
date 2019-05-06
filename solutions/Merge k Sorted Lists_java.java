/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        // merge h2 to h1
        ListNode dummyHead = new ListNode(-1);  
        dummyHead.next = h1;
        
        ListNode cur = dummyHead;
        
        while (h2 != null) {
            while (cur.next != null && cur.next.val <= h2.val) {
                cur = cur.next;
            }
            if (cur.next == null) {
                cur.next = h2;
                break;
            }
            ListNode h2next = h2.next;
            h2.next = cur.next;
            cur.next = h2;
            cur = cur.next;
            h2 = h2next;
        }
        
        return dummyHead.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newhead = null;
        for (int i = 0;i < lists.length;i ++) {
            newhead = merge(newhead, lists[i]);
        }
        return newhead;
    }
}