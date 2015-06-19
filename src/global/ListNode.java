package global;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public String toString() {
		String res = "";
		ListNode tmp = this;
		
		while (tmp != null) {
			res += tmp.val;
			tmp = tmp.next;
			if (tmp != null) res += "-->";
		}


		return res;
	}
	
	
}
