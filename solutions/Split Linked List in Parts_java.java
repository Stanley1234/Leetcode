/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int getLen(ListNode node) {
      int len = 0;
      while (node != null) {
         len ++;
         node = node.next;
      }
      return len;
   }

   public ListNode[] splitListToParts(ListNode root, int parts) {
      int lenOfList = getLen(root);

      ListNode[] res = new ListNode[parts];
      int resCnt = 0;

      while (parts > 0) {
         if (lenOfList == 0) {
            break;
         }
          
         int lenOfSeg;
         if (lenOfList > (lenOfList / parts) * parts) {
            lenOfSeg = (lenOfList / parts) + 1;
         } else {
            lenOfSeg = lenOfList / parts;
         }
         lenOfList -= lenOfSeg;
         parts --;

         res[resCnt] = root;
         while (lenOfSeg > 1) {
            root = root.next;
            lenOfSeg --;
         }
         ListNode next = root.next;
         root.next = null;
         root = next;

         resCnt ++;
      }

      return res;
   }
}