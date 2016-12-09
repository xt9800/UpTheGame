/**
解题思路：
    1. In order to swap node A, B. Need handles on A.previous, and A itself. 
    2. Loop condition, A!=null && A.next != null
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
    public ListNode swapPairs(ListNode head) {
        if(head == null)
        {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode n = dummyHead;
        ListNode p = head;
        
        while(p!=null && p.next!=null)
        {
            n.next = p.next;
            p.next = p.next.next;
            n.next.next = p;
            n=p;
            p=p.next;
        }
        
        return dummyHead.next;
        
    }
}
