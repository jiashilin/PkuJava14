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
    //�����Ǽ��һ�����������Ƿ��ǻػ�����ͬʱ��ʱ�临�ӶȺͿռ临�Ӷȶ�������Ҫ��
	//�ҵ�˼·�ǿ��Խ���������������������
	//��������ǰ��������ֵ��Ȼ��ͺ���������бȽ�
    
    //����һ���µ�˫���б�
	//Linkedlist<Integer> l = new Linkedlist<>();
	LinkedList<Integer> l = new LinkedList<>();
	
	//һ�������������������Ϊ��ʱ��������������ǻػ�����
	if(head == null || head.next == null) return true;
	
	/*����򵥽���һ���㷨��˼��
    ��Ϊ�������ǵ����������Կ�����������ָ��������ȡһ���˼��
    һ��ָ��ÿ��������һ��ָ�룬��һ��ÿ������������ָ��
    �������ǰһ�뵹�÷��������к��ǰ������Ԫ�ؽ�������Ƚ�	
	*/
	
	//�������ǰһ�뵹�÷���������
	//ListNode a = ListNode head;
	//ListNode b = ListNode head;
	
	ListNode a = head;
	ListNode b = head;
	
	l.add(0,a.val);
	
	//while(b.next != null || b.next.next != null){
	while(b.next != null && b.next.next != null){
	b = b.next.next;
	a = a.next;
	l.add(0,a.val); //һֱ��Ԫ�ز嵽��λ�ã����൱�ڵ��ã��ں���ıȽϵ��оͻ�ܷ���	
	}
	//���������������ǵ�������ǰ��αȺ��ζ�һ�����֣������ż��������ô�������
	
	//������ǰ����Ԫ�ؽ�������Ƚ�
	
	if(b.next != null) { //��Ϊ��ǰ���ѭ���������ˣ������������˵������Ԫ�ظ���Ϊż��
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