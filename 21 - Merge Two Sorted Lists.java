/**
解题思路：
    1. In place - 所以是把一个list merge到另一个里面去， 所以一开始选定一个list作为基础（哪个第一个小选哪个）
    2. 如果有一个list traverse到末端了，就不需要再比较了，直接append所有剩余的，或者就直接return l1了（当l2到头了的情况）
    3. 循环比较条件： l1.next.val > l2.val  （当l1中元素大于l2的元素时，将l2插入到l1这个比较元素的前面）
    4. 循环边界条件： l1.next!=null && l2 !=null
注意事项：
    1. 只要不会再touch head， 就不需要dummyhead了
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
