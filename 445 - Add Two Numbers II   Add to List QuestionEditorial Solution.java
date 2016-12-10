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


/**
Solution#2

解题思路：
    1. use recursion to solve this. 
    2. the idea is recursion call return a node(rn) with result and carry, then do addition on current node adding the carry and generate a new node(nn) to get added before rn then return.
    3. how do we return both carry and node. (Trick, return node with value of the whole addition operation(without doing mod with 10), so it carries carry information. We can modify it when we get it.)
    4. recursion only works on same length, so we have to do zero padding for the shorter legnth one.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        {
            return l1 == null?l2:l1;
        }
        if(l1.val == 0 || l2.val == 0)
        {
            return l1.val == 0?l2:l1;
        }
        
        int len1 = length(l1), len2 = length(l2);
        if(len1>len2)
        {
            l2 = zeroPadding(l2, len1-len2);
        }
        else if(len2 > len1)
        {
            l1 = zeroPadding(l1, len2-len1);
        }
        
        ListNode rtr = addTwoNumbersRecursive(l1, l2);
        if(rtr.val >= 10)
        {
            int carry = rtr.val/10;
            rtr.val = rtr.val%10;
            ListNode nn = new ListNode(carry);
            nn.next = rtr;
            rtr = nn;
        }
        return rtr;
    }
    
    private ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2)
    {
        if(l1.next == null)
        {
            return new ListNode(l1.val + l2.val);
        }
        
        ListNode prevnode = addTwoNumbersRecursive(l1.next, l2.next);
        int carry = prevnode.val/10;
        prevnode.val = prevnode.val%10;
        ListNode curnode = new ListNode(l1.val+l2.val+carry);
        curnode.next = prevnode;
        return curnode;
    }
    
    private int length(ListNode head)
    {
        int count = 0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
    
    private ListNode zeroPadding(ListNode head, int len)
    {
        ListNode newhead = head;
        for(int i=0; i<len; i++)
        {
            ListNode zeronode = new ListNode(0);
            zeronode.next = newhead;
            newhead = zeronode;
        }
        return newhead;
    }
}
