/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null) {
         return null;
      }

      ListNode curNode = head;
      while (curNode != null && curNode.next != null) {
         if (curNode.val == curNode.next.val) {
            ListNode nextNode = curNode.next;
            while (nextNode != null && nextNode.val == curNode.val) {
               nextNode = nextNode.next;
            }
            curNode.next = nextNode;
         }
         curNode = curNode.next;
      }
      return head;
   }
}