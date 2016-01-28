public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
  	int len = 0; ListNode cur = head;
  	
  	while (cur != null) {
  		len++;
  		cur = cur.next;
  	}
  	
  	int group = len / k;
  	
  	ListNode krev = new ListNode(-1), dummy = krev; cur = head;
  	
  	while (group-- > 0) {
  		ListNode tail =  cur;
  		ListNode rev = null;
  		int m = k;
  		
  		while (m-- > 0) {
  			ListNode temp = cur.next;
  			cur.next = rev;
  			rev = cur; cur = temp;
  		}

  		krev.next = rev; krev = tail;
  	}
  	
  	krev.next = cur;
  	
  	return dummy.next;
  }
}
