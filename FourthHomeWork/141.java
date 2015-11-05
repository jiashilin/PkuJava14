/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode pre=head;
        ListNode last=head;
        if(pre!=null){
            pre=head.next;
        }
       
        while(pre!=null){
            if(pre==last)
                return true;
            if(pre.next!=null){
                pre=pre.next.next;
            }else{
                return false;}
            last=last.next;
        }
        return false;
    }
}