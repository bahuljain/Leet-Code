public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null || m == n) return head;
    	ListNode cur = new ListNode(0); cur.next = head;
    	ListNode dummy = cur;

    	while (m > 1) {
    		cur = cur.next;
    		m--; n--;
    	}

    	ListNode prev = cur;
    	ListNode tail = cur.next;
    	cur = cur.next;
    	ListNode revHead = null;

    	while(n-- > 1) {
    		prev.next = cur.next;
    		cur.next = revHead;
    		revHead = cur;
    		cur = prev.next;
    	}

    	tail.next = cur.next;
    	cur.next = revHead;

    	return dummy.next;
    }

}
