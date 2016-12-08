/**
解题思路：
    1. start from dummyhead, always compares r.next == val, if true, do deletion r.next = r.next.next;
    2. loop condtion: r.next != null;
注意事项：
    1. maybe all delete node questions dont need to record prev node. just compares r.next.val is enough for deletion.
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
        {
            return null;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode p = dummyhead;
        while(p.next !=null)
        {
            if(p.next.val == val)
            {
                p.next = p.next.next;
            }
            else
            {
                p = p.next;
            }
        }
        return dummyhead.next;
    }
}
