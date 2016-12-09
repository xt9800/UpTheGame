/**
解题思路：
    1. to delete node A, just do A.val = A.next.val   and    A.next = A.next.next;
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
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null)
        {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
