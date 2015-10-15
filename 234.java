/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
    //本题是检测一个单向链表是否是回环链表，同时对时间复杂度和空间复杂度都进行了要求
	//我的思路是可以将这个链表问题和数组相结合
	//用数组存放前半段链表的值，然后和后半段链表进行比较
    
    //生成一个新的双向列表
	//Linkedlist<Integer> l = new Linkedlist<>();
	LinkedList<Integer> l = new LinkedList<>();
	
	//一种特殊情况当给定链表为空时，这个单向链表是回环链表
	if(head == null || head.next == null) return true;
	
	/*下面简单介绍一下算法的思想
    因为给定的是单向链表所以可以设置两个指针来进行取一半的思想
    一个指针每次跳到下一个指针，另一个每次跳到下两个指针
    将链表的前一半倒置放入数组中后对前后两段元素进行逐个比较	
	*/
	
	//将链表的前一半倒置放入数组中
	//ListNode a = ListNode head;
	//ListNode b = ListNode head;
	
	ListNode a = head;
	ListNode b = head;
	
	l.add(0,a.val);
	
	//while(b.next != null || b.next.next != null){
	while(b.next != null && b.next.next != null){
	b = b.next.next;
	a = a.next;
	l.add(0,a.val); //一直将元素插到首位置，就相当于倒置，在后面的比较当中就会很方便	
	}
	//按照这个规则如果是单数链表，前半段比后半段多一个数字，如果是偶数链表那么长短相等
	
	//对链表前后半段元素进行逐个比较
	
	if(b.next != null) { //因为从前面的循环跳出来了，所以这个条件说明链表元素个数为偶数
	a = a.next;	
	}
	
	int i = 0;
	while(a != null){
	if(l.get(i) != a.val)
	return false;
	a = a.next;
	i++;
	}
	return true;
	
        
    }
}