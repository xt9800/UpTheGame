/**
解题思路：
    1. find the middle point M of the list(two runner), and laterHead = M.next; (loop cond: p2.next!=null && p2.next.next!=null)
    2. reverse laterHead list(second half), (loop cond: laterhead.next!=null)
    3. merge laterHead with head list.(loop cond: head != null, laterhead !=null)
    
注意事项：
    
Complexity：
    O(n)
Space:
    O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        {
            return;
        }
        
        //find mid point
        ListNode r1 = head, r2 = head;
        while(r2.next!=null && r2.next.next!=null)
        {
            r2 = r2.next.next;
            r1 = r1.next;
        }
        ListNode laterhead = r1.next;
        r1.next = null;
        
        //reverse laterhead list(second half)
        ListNode p = laterhead;
        while(p.next != null)
        {
            ListNode temp = p.next;
            p.next = temp.next;
            temp.next = laterhead;
            laterhead = temp;
        }
        
        //merge 2 list;
        p = head;
        while(p!=null && laterhead !=null)
        {
            ListNode temp = laterhead;
            laterhead = laterhead.next;
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
    }
}
