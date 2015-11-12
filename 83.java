/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    //考虑第一个特殊情况，head为空或者head.next为空则直接返回head
    //if（head == null || head.next == null） return head;
    
    if(head == null || head.next == null){
        return head;
    } 
    
    //题意就是给一个链表指针，去掉其中重复的节点
    ListNode a = head;
    ListNode temp = head;
    
    while(a != null && a.next != null){
         temp = a.next;
         while((temp != null) && (temp.val == a.val)){
             temp = temp.next;
         }
         a.next = temp;
         if(a != null){
             a = a.next;
         }
    }
    
    return head;
        
    }
}