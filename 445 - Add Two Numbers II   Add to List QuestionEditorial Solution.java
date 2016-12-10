/**
Solution#1
解题思路：
    1. using 2 stacks and push everything from 2 list to stacks.
    2. poping stakcs and start creating the result list.
注意事项：
    1. edge case#1: null just return the other
    2. edge case#2: 0 head just return the other 
Complexity：
    O(n)
Space:
    O(n)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        {
            return l1 == null?l2:l1;
        }
        if(l1.val == 0 || l2.val == 0)
        {
            return l1.val == 0?l2:l1;
        }
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1!=null)
        {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null)
        {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null;
        while(!s1.empty() || !s2.empty())
        {
            if(!s1.empty())
            {
                carry += s1.pop();
            }
            
            if(!s2.empty())
            {
                carry += s2.pop();
            }
            
            ListNode nn = new ListNode(carry%10);
            nn.next = head;
            head = nn;
            carry = carry/10;
        }
        
        if(carry!=0)
        {
            ListNode nn = new ListNode(carry);
            nn.next = head;
            head = nn;
        }
        return head;
    }
}
