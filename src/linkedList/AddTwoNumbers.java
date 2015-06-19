package linkedList;

import global.ListNode;

public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode(0);
		ListNode previous = dummy;
		int carry = 0;
		
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		while (l1 != null || l2 != null || carry > 0) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			
			carry = sum / 10;
			ListNode tmp = new ListNode(sum % 10);
			previous.next = tmp;
			previous = tmp;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(8);
		n1.next = n2;
		
		ListNode m1 = new ListNode(9);
		
		ListNode res = addTwoNumbers(n1, m1);
		System.out.println(res);
		
		
	}
}
