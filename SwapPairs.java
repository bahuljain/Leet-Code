
// Loved my solution!! :) Finally getting good with Linked Lists
public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;

		ListNode cur = head;
		head = cur.next;

		cur.next = swapPairs(head.next);
		head.next = cur;

		return head;
	}
}
