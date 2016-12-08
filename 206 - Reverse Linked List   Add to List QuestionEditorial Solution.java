/**
解题思路：
    1. no need to create new node instances, just keep cutting out node and throw it into the beginning of the list.
    2. keep track/update the head of the node. 
    3. loop condition: when p.next == null, meaning the origin first node is pointing to null, meaning origin first node is at the end and we are done reversing.
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
    public ListNode reverseList(ListNode head) {
        if(head == null)
        {
            return head;
        }
        ListNode p = head;
        while(p.next!=null)
        {
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
