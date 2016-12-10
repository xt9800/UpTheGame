/**
解题思路：
    1. 2 pointers. PO(odds) and PE(even), PE.next is always odd node, cut it out and insert after PO. 
    2. loop condition: PE.next!=null
    3. edge case: null case and one node case just return head.
                  2 node case will be handled by regular logic.
注意事项：
    This one is not messing with head so no dummyhead needed.
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode po = head, pe = head.next;
        while(pe!=null && pe.next!=null)
        {
            ListNode temp = pe.next;
            pe.next = temp.next;
            temp.next = po.next;
            po.next = temp;
            po = po.next;
            pe = pe.next;
        }
        
        return head;
    }
}
