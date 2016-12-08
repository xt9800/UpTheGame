
/**
解题思路：
  1. Two runners, r1 is ahead of r2 by n steps first. Then r1, r2 travse 1 step at a time together.
  2. n steps ahead means r2 is at n+1th from the end when r1 reach last node. This is where r2 should be to perform a delete. 
  3. delete is something like:
      r2.next = r2.next.next;
  4. both r1,r2 start from dummyhead, so that if there is only one node, its still fine for r2 being dummyhead to delete the frist node.
  5. loop end condition: r1.next == null
注意事项：
  1. Think about n greater than length of the list. Should just throw exception during loop of r1 first start travse ahead n steps.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        {
            return head;
        }
        
        ListNode dummyhead = new ListNode(0);
        
        dummyhead.next = head;
        ListNode r1 = dummyhead;
        ListNode r2 = dummyhead;
        
        for(int i=0; i<n; i++)
        {
            r1 = r1.next;
            /*if(r1 == null)
            {
                throw new Exception();//if n > list.length(), throw exception.
            }*/
        }
        
        while(r1.next != null)
        {
            r1 = r1.next;
            r2 = r2.next;
        }
        r2.next = r2.next.next;
        return dummyhead.next;
    }
}
