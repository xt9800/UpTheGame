/**
解题思路：
    1. Traverse LinkedList, when see one not in order (p.val > p.next.val), start another while loop to traverse from beginning to see where to insert p.next. 
    2. Loop condtion (outter): p.next!=null;
    3. Loop condtion (inner): pp=dummy --> while(pp.next.val < p.next) --> keep moving
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
        {
            return head;
        }
        
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode p = head;
        while(p.next!=null)
        {
            if(p.next.val < p.val)
            {
                ListNode pp = dummyhead;
                while(pp.next.val<p.next.val)
                {
                    pp = pp.next;
                }
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next = pp.next;
                pp.next = temp;
            }
            else
            {
                p = p.next;
            }
        }
        return dummyhead.next;
    }
}
