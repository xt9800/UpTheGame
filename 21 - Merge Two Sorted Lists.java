/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        {
            return l1 == null?l2:l1;
        }
        
        if(l1.val>l2.val)
        {
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
        }
        
        ListNode p = l1; //as long as we dont touch first node from this point on, we dont need dummyhead.
        //ListNode dummyhead = new ListNode(0);
        //dummyhead.next = l1;

        while(l1.next!=null && l2!=null)
        {
            if(l1.next.val>l2.val)
            {
                ListNode temp = l2;
                l2 = l2.next;
                temp.next = l1.next;
                l1.next = temp;
            }
            l1 = l1.next;
        }
        
        if(l1.next == null)
        {
            l1.next = l2;
        }
        
        return p;
        
    }
}
