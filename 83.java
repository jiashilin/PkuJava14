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
    //���ǵ�һ�����������headΪ�ջ���head.nextΪ����ֱ�ӷ���head
    //if��head == null || head.next == null�� return head;
    
    if(head == null || head.next == null){
        return head;
    } 
    
    //������Ǹ�һ������ָ�룬ȥ�������ظ��Ľڵ�
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